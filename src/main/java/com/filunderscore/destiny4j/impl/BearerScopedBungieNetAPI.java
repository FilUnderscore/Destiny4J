package com.filunderscore.destiny4j.impl;

import java.net.URISyntaxException;

import com.filunderscore.destiny4j.api.IScopedAppAPI;
import com.filunderscore.destiny4j.api.IScopedUserAPI;
import com.filunderscore.destiny4j.api.entities.app.IApiUsage;
import com.filunderscore.destiny4j.api.entities.auth.IAccessTokenResponse;
import com.filunderscore.destiny4j.api.entities.user.membership.IUserMembershipData;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.api.rest.IRestRequest;
import com.filunderscore.destiny4j.impl.entities.user.UserMembershipData;
import com.filunderscore.destiny4j.impl.rest.NullRestRequest;
import com.filunderscore.destiny4j.impl.rest.RestKVP;
import com.filunderscore.destiny4j.impl.rest.http.HttpUriGetRestRequest;
import com.filunderscore.destiny4j.impl.rest.http.HttpUriRestSession;

public final class BearerScopedBungieNetAPI extends BasicScopedBungieNetAPI implements IScopedAppAPI, IScopedUserAPI
{
	private long lastRenewedSeconds;

	private IAccessTokenResponse previousRenewResponse;
	private HttpUriRestSession session;
	
	public BearerScopedBungieNetAPI(BasicScopedBungieNetAPI basicScopedAPI, IAccessTokenResponse accessTokenResponse)
	{
		super(basicScopedAPI);
		
		this.previousRenewResponse = accessTokenResponse;
		this.session = this.constructAuthorizedSession();
	}
	
	private IRestKVP constructAuthorizationKVP()
	{
		return new RestKVP("Authorization", "Bearer " + this.previousRenewResponse.getAccessToken());
	}
	
	private HttpUriRestSession constructAuthorizedSession()
	{
		return new HttpUriRestSession(this, this.client, this.context, new IRestKVP[] { this.api_key_rest_kvp, this.constructAuthorizationKVP() });
	}

	@Override
	public IRestRequest<IApiUsage> getApplicationApiUsage() 
	{
		return null;
	}

	@Override
	public IRestRequest<IApiUsage> getApplicationApiUsage(int applicationId) 
	{
		return null;
	}

	@Override
	public IRestRequest<IAccessTokenResponse> renewAccessToken() 
	{
		long currentSeconds = System.currentTimeMillis() / 1000;
		
		if(this.lastRenewedSeconds + this.previousRenewResponse.getExpiresIn() < currentSeconds)
		{
			return this.renewAccessToken(this.previousRenewResponse.getRefreshToken()).success(response ->
			{
				this.previousRenewResponse = response;
				this.lastRenewedSeconds = currentSeconds;
				this.session = this.constructAuthorizedSession();
			});
		}
		else
		{
			return new NullRestRequest<IAccessTokenResponse>(this.previousRenewResponse);
		}
	}

	@Override
	public IRestRequest<IUserMembershipData> getMembershipDataForCurrentUser() 
	{
		try 
		{
			return new HttpUriGetRestRequest<IUserMembershipData>(UserMembershipData.class, this.session, API_URL + "/User/GetMembershipsForCurrentUser/", new IRestKVP[0], new IRestKVP[0]);
		} 
		catch (URISyntaxException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
}