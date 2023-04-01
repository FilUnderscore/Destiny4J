package com.filunderscore.destiny4j.manifest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.bungie.api.destiny.definitions.DestinyDefinition;

public final class DestinyManifestJSON extends DestinyManifest
{
	private Map<Class<? extends DestinyDefinition>, Map<Long, DestinyDefinition>> definitions = new HashMap<>();
	
	@Override
	public void loadDefinitions()
	{
		this.definitions.clear();
		
		try
		{
			JsonObject jsonWorldContent = get(this.manifest.jsonWorldContentPaths.get("en"));
			
			for(Entry<String, JsonElement> entry : jsonWorldContent.entrySet())
			{
				String key = entry.getKey();
				JsonObject definitions = entry.getValue().getAsJsonObject();
	
				if(!DEFINITION_CLASSES.containsKey(key))
				{
					System.out.println("No such definition implemented with key \"" + key + "\".");
					continue;
				}
				
				for(Entry<String, JsonElement> definitionEntry : definitions.entrySet())
				{
					long hash = Long.valueOf(definitionEntry.getKey());
					JsonObject definitionJson = definitionEntry.getValue().getAsJsonObject();
					
					Class<? extends DestinyDefinition> definitionClass = DEFINITION_CLASSES.get(key);
					DestinyDefinition definition = gson.fromJson(definitionJson, definitionClass);
					
					if(!this.definitions.containsKey(definitionClass))
						this.definitions.put(definitionClass, new HashMap<>());
					
					this.definitions.get(definitionClass).put(hash, definition);
					
					System.out.println(String.format("Registered %s with hash %d", key, hash));
				}
			}
		}
		catch(IOException | URISyntaxException e)
		{
			System.err.println("Failed to parse manifest.");
			e.printStackTrace();
		}
	}
	
	private final JsonObject get(String path) throws URISyntaxException, ClientProtocolException, IOException
	{
		URIBuilder builder = new URIBuilder(URL + path);
		HttpGet get = new HttpGet(builder.build());
		
		HttpResponse response = client.execute(get);
		String jsonString = EntityUtils.toString(response.getEntity());
		
		System.out.println(String.format("GET %s %s", path, ""));

		JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
		return json;
	}
	
	@Override
	public <T extends DestinyDefinition> T getDefinition(long hash, Class<T> clazz)
	{
		return (T) definitions.get(clazz).get(hash);
	}

	@Override
	public <T extends DestinyDefinition> List<T> getAllDefinitionsOfType(Class<T> clazz) 
	{
		List<T> definitionList = new ArrayList<>();
		
		for(DestinyDefinition definition : definitions.get(clazz).values())
		{
			definitionList.add((T)definition);
		}
		
		return definitionList;
	}
}