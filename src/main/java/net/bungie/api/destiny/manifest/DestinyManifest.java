package net.bungie.api.destiny.manifest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.gson.Gson;

import net.bungie.api.destiny.DestinyAPI;
import net.bungie.api.destiny.DestinyAPI.APIErrorException;
import net.bungie.api.destiny.definitions.DestinyDefinition;

public abstract class DestinyManifest 
{
	protected static final String URL = "https://www.bungie.net";
	protected static final BiMap<String, Class<? extends DestinyDefinition>> DEFINITION_CLASSES;
	
	static
	{
		DEFINITION_CLASSES = HashBiMap.create();
		
		Reflections reflections = new Reflections("net.bungie.api.destiny.definitions");
		
		for(Class<?> clazz : reflections.get(Scanners.SubTypes.of(DestinyDefinition.class).asClass()))
		{
			DEFINITION_CLASSES.put(clazz.getSimpleName(), (Class<? extends DestinyDefinition>)clazz);
		}
	}
	
	private static DestinyManifest instance;
	protected DestinyAPI api;
	
	protected HttpClient client = HttpClients.createDefault();
	protected Gson gson = new Gson();
	
	private static final List<DestinyManifestCallback> callbacks = new ArrayList<>();
	
	protected DestinyManifest()
	{
		this.api = new DestinyAPI(APIKey);
	}
	
	private static String APIKey;

	public static void init(String apiKey, DestinyManifestFormat format)
	{
		APIKey = apiKey;
		
		switch(format)
		{
		case JSON:
			instance = new DestinyManifestJSON();
			break;
		case SQLite:
			instance = new DestinyManifestSQLite();
			break;
		}
	}
	
	public static enum DestinyManifestFormat
	{
		JSON,
		SQLite;
	}
	
	public static DestinyManifest getInstance()
	{
		if(instance == null)
			throw new NullPointerException("DestinyManifest has not been initialized! Call init() with the API Key and Manifest Format you would like to use.");
			
		instance.refreshManifestIfNeeded();
		
		return instance;
	}
	
	protected net.bungie.api.destiny.config.DestinyManifest manifest;
	private Date manifestRefreshDate;
	
	public abstract void loadDefinitions();
	
	private void refreshManifestIfNeeded()
	{
		if(manifestRefreshDate == null || new Date().after(this.manifestRefreshDate))
		{
			this.refresh();
		}
	}
	
	public final void refresh()
	{
		System.out.println("Fetching updated Destiny Manifest.");
		
		try 
		{
			this.manifest = this.api.getDestinyManifest();
			
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("PST"));
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR_OF_DAY, 10);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			this.manifestRefreshDate = calendar.getTime();
		} 
		catch (APIErrorException e1) // TODO
		{
			e1.printStackTrace();
		}
		
		this.loadDefinitions();
		
		System.out.println(String.format("Destiny Manifest updated to version %s", this.manifest.version));
		
		for(DestinyManifestCallback callback : callbacks)
		{
			callback.onManifestRefreshed(this);
		}
	}
	
	public static final void registerCallback(DestinyManifestCallback callback)
	{
		callbacks.add(callback);
	}
	
	public abstract <T extends DestinyDefinition> T getDefinition(long hash, Class<T> clazz);

	public final <T extends DestinyDefinition> T[] getDefinitions(long[] hashes, Class<T> clazz)
	{
		if(hashes == null)
			return null;
		
		T[] definitions = (T[]) Array.newInstance(clazz, hashes.length);
		
		for(int i = 0; i < hashes.length; i++)
		{
			definitions[i] = getDefinition(hashes[i], clazz);
		}
		
		return definitions;
	}

	public final <T extends DestinyDefinition> T[] getDefinitions(Long[] hashes, Class<T> clazz)
	{
		if(hashes == null)
			return null;
		
		List<T> definitions = new ArrayList<>();
		
		for(int i = 0; i < hashes.length; i++)
		{
			if(hashes[i] == null)
				continue;
			
			definitions.add(getDefinition(hashes[i], clazz));
		}
		
		return (T[]) definitions.toArray();
	}
	
	public abstract <T extends DestinyDefinition> List<T> getAllDefinitionsOfType(Class<T> clazz);
	
	public final <T extends DestinyDefinition> T getMappedDefinition(long hashDefMappedTo, Class<T> clazz)
	{
		return null;
	}
}