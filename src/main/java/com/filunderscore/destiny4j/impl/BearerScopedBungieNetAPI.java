package com.filunderscore.destiny4j.impl;

import com.filunderscore.destiny4j.api.IScopedAppAPI;
import com.filunderscore.destiny4j.api.IScopedUserAPI;
import com.filunderscore.destiny4j.api.entities.app.IApiUsage;
import com.filunderscore.destiny4j.api.entities.auth.IAccessTokenResponse;
import com.filunderscore.destiny4j.api.entities.user.membership.IUserMembershipData;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.api.rest.IRestRequest;
import com.filunderscore.destiny4j.impl.rest.NullRestRequest;
import com.filunderscore.destiny4j.impl.rest.RestKVP;

public final class BearerScopedBungieNetAPI extends BasicScopedBungieNetAPI implements IScopedAppAPI, IScopedUserAPI
{
	private long lastRenewedSeconds;
	private IAccessTokenResponse previousRenewResponse;
	
	public BearerScopedBungieNetAPI(BasicScopedBungieNetAPI basicScopedAPI, IAccessTokenResponse accessTokenResponse)
	{
		super(basicScopedAPI);
		
		this.previousRenewResponse = accessTokenResponse;
	}
	
	private IRestKVP constructAuthorizationKVP()
	{
		return new RestKVP("Authorization", "Bearer " + this.previousRenewResponse.getAccessToken());
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
		return null;
	}
}