package com.filunderscore.destiny4j.manifest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.filunderscore.destiny4j.api.entities.manifest.IDestinyDefinitionEntity;
import com.filunderscore.destiny4j.api.entities.manifest.IDestinyManifest;

public final class SQLiteDestinyEntityManifestParser extends DestinyEntityManifestParser
{
	private Connection conn = null;
	
	@Override
	protected void updateManifestData(IDestinyManifest manifest) 
	{
		try
		{
			if(conn != null)
				conn.close();
			
			String dbZipPath = URL + manifest.getMobileWorldContentPaths().get("en");
			FileUtils.copyURLToFile(new URL(dbZipPath), new File("manifest.zip"));
			
			File dbZip = new File("manifest.zip");
			
			try(ZipFile zipFile = new ZipFile(dbZip, ZipFile.OPEN_READ))
			{
				zipFile.stream().forEach(zipEntry -> 
				{
					try(InputStream in = zipFile.getInputStream(zipEntry))
					{
						try(OutputStream out = new FileOutputStream("manifest.sqlite"))
						{
							IOUtils.copy(in, out);
						}
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				});
			}
			
			System.out.println("Finished extracting Manifest database.");
			
			dbZip.delete();
			File db = new File("manifest.sqlite");
			
			conn = DriverManager.getConnection("jdbc:sqlite:" + db.getCanonicalPath());
		}
		catch (SQLException | IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	protected <T extends IDestinyDefinitionEntity> T getDefinitionEntity(Class<T> definitionEntityClass, long hash) 
	{
		if(!DestinyEntityManifest.DEFINITION_CLASSES.inverse().containsKey(definitionEntityClass))
			return null;
		
		String definitionTable = DestinyEntityManifest.DEFINITION_CLASSES.inverse().get(definitionEntityClass);
		
		try 
		{
			String table = String.format("SELECT json FROM %s WHERE id = %s;", definitionTable, hash > (long)Integer.MAX_VALUE ? hash - (((long)Integer.MAX_VALUE + 1L) * 2) : hash);
			ResultSet query = conn.createStatement().executeQuery(table);
			
			if(query.next())
			{
				return gson.fromJson(query.getString("json"), definitionEntityClass);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T extends IDestinyDefinitionEntity> T[] getAllDefinitionEntities(Class<T> definitionEntityClass) 
	{
		if(!DestinyEntityManifest.DEFINITION_CLASSES.inverse().containsKey(definitionEntityClass))
			return null;
		
		String definitionTable = DestinyEntityManifest.DEFINITION_CLASSES.inverse().get(definitionEntityClass);
		List<T> definitionList = new ArrayList<>();
		
		try 
		{
			String table = String.format("SELECT json FROM %s;", definitionTable);
			ResultSet query = conn.createStatement().executeQuery(table);
			
			while(query.next())
			{
				T definition = gson.fromJson(query.getString("json"), definitionEntityClass);
				definitionList.add(definition);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return (T[]) definitionList.toArray(size -> new IDestinyDefinitionEntity[size]);
	}
}