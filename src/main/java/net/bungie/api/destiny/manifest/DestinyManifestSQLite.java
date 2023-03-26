package net.bungie.api.destiny.manifest;

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

import net.bungie.api.destiny.definitions.DestinyDefinition;

public class DestinyManifestSQLite extends DestinyManifest
{
	private Connection conn = null;
	
	@Override
	public void loadDefinitions() 
	{
		try
		{
			if(conn != null)
				conn.close();
			
			String dbZipPath = URL + this.manifest.mobileWorldContentPaths.get("en");
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
	public <T extends DestinyDefinition> T getDefinition(long hash, Class<T> clazz) 
	{
		if(!DEFINITION_CLASSES.inverse().containsKey(clazz))
			return null;
		
		String definitionTable = DEFINITION_CLASSES.inverse().get(clazz);
		
		try 
		{
			String table = String.format("SELECT json FROM %s WHERE id = %s;", definitionTable, hash > (long)Integer.MAX_VALUE ? hash - (((long)Integer.MAX_VALUE + 1L) * 2) : hash);
			ResultSet query = conn.createStatement().executeQuery(table);
			
			if(query.next())
			{
				return gson.fromJson(query.getString("json"), clazz);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public <T extends DestinyDefinition> List<T> getAllDefinitionsOfType(Class<T> clazz) 
	{
		if(!DEFINITION_CLASSES.inverse().containsKey(clazz))
			return null;
		
		String definitionTable = DEFINITION_CLASSES.inverse().get(clazz);
		List<T> definitionList = new ArrayList<>();
		
		try 
		{
			String table = String.format("SELECT json FROM %s;", definitionTable);
			ResultSet query = conn.createStatement().executeQuery(table);
			
			while(query.next())
			{
				T definition = gson.fromJson(query.getString("json"), clazz);
				definitionList.add(definition);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return definitionList;
	}
}