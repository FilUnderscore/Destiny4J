package com.filunderscore.destiny4j.impl.rest.http.auth;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import org.apache.http.client.methods.HttpUriRequest;

import com.filunderscore.destiny4j.api.entities.auth.IAccessTokenResponse;
import com.filunderscore.destiny4j.api.exceptions.IBungieNetError;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.api.rest.scoped.IScopedRestRequest;
import com.filunderscore.destiny4j.impl.BearerScopedBungieNetAPI;
import com.filunderscore.destiny4j.impl.rest.http.HttpUriRestRequest;
import com.filunderscore.destiny4j.impl.rest.http.HttpUriRestSession;

public abstract class AuthorizedHttpUriRestRequest<Response, Request extends HttpUriRequest> extends HttpUriRestRequest<Response, Request> implements IScopedRestRequest<Response>
{
	private final BearerScopedBungieNetAPI scopedBungieNet;
	
	private Consumer<Void> authFailed;
	
	public AuthorizedHttpUriRestRequest(BearerScopedBungieNetAPI scopedBungieNet, Class<? extends Response> responseClass, HttpUriRestSession session, String url,
			IRestKVP[] urlParams, IRestKVP[] additionalHeaders) 
	{
		super(responseClass, session, url, urlParams, additionalHeaders);
		
		this.scopedBungieNet = scopedBungieNet;
	}

	@Override
	public final IScopedRestRequest<Response> authFailed(Consumer<Void> response) 
	{
		this.authFailed = response;
		
		return this;
	}
	
	private IBungieNetError renewError = null;
	
	@Override
	public final Future<Result> makeRequest()
	{
		// Renew access token first.
		IAccessTokenResponse accessTokenResponse = this.scopedBungieNet.renewAccessToken().fail(error ->
		{
			this.authFailed.accept(null);
			renewError = error;
		}).execute();
	
		if(accessTokenResponse == null || renewError != null)
			return CompletableFuture.completedFuture(new Result(renewError));
		
		return super.makeRequest();
	}
}