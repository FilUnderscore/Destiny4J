package com.filunderscore.destiny4j;

import com.filunderscore.destiny4j.api.entities.auth.IAccessTokenResponse;
import com.filunderscore.destiny4j.impl.BasicScopedBungieNetAPI;
import com.filunderscore.destiny4j.impl.BearerScopedBungieNetAPI;
import com.filunderscore.destiny4j.impl.BungieNetAPI;

public final class Destiny4J 
{
	public static BungieNetAPI buildAPI(String api_key)
	{
		return new BungieNetAPI(api_key);
	}
	
	public static BasicScopedBungieNetAPI buildAuthenticationAPI(String api_key, String client_id, String client_secret)
	{
		return new BasicScopedBungieNetAPI(api_key, client_id, client_secret);
	}
	
	public static BearerScopedBungieNetAPI buildAuthenticatedAPI(BasicScopedBungieNetAPI api, String refreshToken)
	{
		return buildAuthenticatedAPI(api, api.renewAccessToken(refreshToken).execute());
	}
	
	public static BearerScopedBungieNetAPI buildAuthenticatedAPI(BasicScopedBungieNetAPI api, IAccessTokenResponse response)
	{
		if(response == null)
			return null;
		
		return new BearerScopedBungieNetAPI(api, response);
	}
}