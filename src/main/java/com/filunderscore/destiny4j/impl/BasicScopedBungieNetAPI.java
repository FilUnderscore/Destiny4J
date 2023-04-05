package com.filunderscore.destiny4j.impl;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.http.message.BasicNameValuePair;

import com.filunderscore.destiny4j.api.IOAuth2API;
import com.filunderscore.destiny4j.api.entities.auth.IAccessTokenResponse;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.api.rest.IRestRequest;
import com.filunderscore.destiny4j.impl.rest.RestKVP;
import com.filunderscore.destiny4j.impl.rest.http.HttpUriRestSession;
import com.filunderscore.destiny4j.impl.rest.http.UrlEncodedFormHttpUriPostRestRequest;

public class BasicScopedBungieNetAPI extends BungieNetAPI implements IOAuth2API
{
	private final IRestKVP client_auth_token_rest_kvp;
	private final HttpUriRestSession session;
	
	public BasicScopedBungieNetAPI(String api_key, String client_id, String client_secret) 
	{
		super(api_key);
		
		String authToken = client_id + ":" + client_secret;
		String base64EncodedAuthToken = Base64.getEncoder().encodeToString(authToken.getBytes(StandardCharsets.UTF_8));
		
		this.client_auth_token_rest_kvp = new RestKVP("Authorization", "Basic " + base64EncodedAuthToken);
		this.session = new HttpUriRestSession(this.client, this.context, new IRestKVP[] { this.api_key_rest_kvp });
	}

	protected BasicScopedBungieNetAPI(BasicScopedBungieNetAPI basicScopedAPI) 
	{
		super(basicScopedAPI);
		
		this.client_auth_token_rest_kvp = basicScopedAPI.client_auth_token_rest_kvp;
		this.session = basicScopedAPI.session;
	}

	@Override
	public IRestRequest<IAccessTokenResponse> renewAccessToken(String refreshToken) 
	{
		try 
		{
			return new UrlEncodedFormHttpUriPostRestRequest<IAccessTokenResponse>(AccessTokenRenewedResponse.class, this.session, API_URL + "/App/OAuth/Token/", new IRestKVP[0], new IRestKVP[] { this.client_auth_token_rest_kvp, new RestKVP("Content-Type", "application/x-www-form-urlencoded") }, new BasicNameValuePair("grant_type", "refresh_token"), new BasicNameValuePair("refresh_token", refreshToken));
		} 
		catch (UnsupportedEncodingException | URISyntaxException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public IRestRequest<IAccessTokenResponse> renewAccessToken() 
	{
		throw new UnsupportedOperationException("Cannot renew access token with a refresh token!");
	}
	
	private final class AccessTokenRenewedResponse implements IAccessTokenResponse
	{
		private String access_token;
		private String refresh_token;
		private long expires_in;
		private long refresh_expires_in;
		
		private String token_type;
		private long membershipId;
		
		private String error;
		private String error_description;
		
		@Override
		public String getAccessToken() 
		{
			return this.access_token;
		}

		@Override
		public String getRefreshToken() 
		{
			return this.refresh_token;
		}

		@Override
		public long getExpiresIn() 
		{
			return this.expires_in;
		}

		@Override
		public long getRefreshExpiresIn() 
		{
			return this.refresh_expires_in;
		}

		@Override
		public String getTokenType() 
		{
			return this.token_type;
		}

		@Override
		public long getMembershipId() 
		{
			return this.membershipId;
		}

		@Override
		public String getError() 
		{
			return this.error;
		}

		@Override
		public String getErrorDescription() 
		{
			return this.error_description;
		}
	}
}