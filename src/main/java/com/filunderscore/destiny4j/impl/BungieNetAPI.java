package com.filunderscore.destiny4j.impl;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.IBungieNet;
import com.filunderscore.destiny4j.api.entities.app.IApplication;
import com.filunderscore.destiny4j.api.entities.manifest.IDestinyManifest;
import com.filunderscore.destiny4j.api.entities.manifest.IManifestEntity;
import com.filunderscore.destiny4j.api.entities.user.IBungieNetUser;
import com.filunderscore.destiny4j.api.entities.user.IUser;
import com.filunderscore.destiny4j.api.entities.user.membership.BungieMembershipType;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.api.rest.IRestRequest;
import com.filunderscore.destiny4j.impl.entities.user.ExactSearchRequest;
import com.filunderscore.destiny4j.impl.rest.HttpUriGetRestRequest;
import com.filunderscore.destiny4j.impl.rest.JsonHttpUriPostRestRequest;
import com.filunderscore.destiny4j.impl.rest.RestKVP;

public class BungieNetAPI implements IBungieNet
{
	protected static final String API_URL = "https://www.bungie.net/Platform";
	protected static final String STATS_API_URL = "https://stats.bungie.net/Platform";
	
	protected final HttpClient client = HttpClients.createDefault();
	protected final HttpContext context = HttpClientContext.create();
	
	protected final IRestKVP api_key_rest_kvp;
	
	public BungieNetAPI(String api_key)
	{
		this.api_key_rest_kvp = new RestKVP("X-API-Key", api_key);
	}
	
	protected BungieNetAPI(BungieNetAPI api)
	{
		this.api_key_rest_kvp = api.api_key_rest_kvp;
	}
	
	@Override
	public IRestRequest<IApplication[]> getBungieApplications() 
	{
		try 
		{
			return new HttpUriGetRestRequest<IApplication[]>(IApplication[].class, client, context, API_URL + "/App/FirstParty", new IRestKVP[0], new IRestKVP[] { this.api_key_rest_kvp });
		} 
		catch (URISyntaxException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public IRestRequest<IDestinyManifest> getDestinyManifest() 
	{
		return null;
	}

	@Override
	public <T extends IManifestEntity> IRestRequest<T> getDestinyEntityDefinition(Class<T> entityType,
			long hashIdentifier) 
	{
		return null;
	}

	@Override
	public IRestRequest<IUser[]> searchDestinyPlayerByBungieName(BungieMembershipType type,
			String displayName, byte displayNameCode) 
	{
		try 
		{
			return new JsonHttpUriPostRestRequest<IUser[], ExactSearchRequest>(IUser[].class, client, context, API_URL + "/Destiny2/SearchDestinyPlayerByBungieName/" + type.getValue() + "/", new RestKVP[0], new IRestKVP[] { this.api_key_rest_kvp }, new ExactSearchRequest(displayName, displayNameCode));
		} 
		catch (UnsupportedEncodingException | URISyntaxException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public IRestRequest<IBungieNetUser> getBungieNetUserById(long membershipId) 
	{
		return null;
	}

	@Override
	public IRestRequest<Map<String, Byte>> getSanitizedPlatformDisplayNames(long membershipId) 
	{
		return null;
	}
}