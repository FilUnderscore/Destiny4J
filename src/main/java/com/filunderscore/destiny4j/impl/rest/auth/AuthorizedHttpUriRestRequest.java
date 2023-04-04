package com.filunderscore.destiny4j.impl.rest.auth;

import java.net.URISyntaxException;
import java.util.function.Consumer;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.IBearerScopedBungieNet;
import com.filunderscore.destiny4j.IBungieNetError;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.api.rest.scoped.IScopedRestRequest;
import com.filunderscore.destiny4j.impl.rest.http.HttpUriRestRequest;

public abstract class AuthorizedHttpUriRestRequest<Response, Request extends HttpUriRequest> extends HttpUriRestRequest<Response, Request> implements IScopedRestRequest<Response>
{
	private final IBearerScopedBungieNet scopedBungieNet;
	
	private Consumer<Void> authFailed;
	
	public AuthorizedHttpUriRestRequest(IBearerScopedBungieNet scopedBungieNet, Class<Response> responseClass, HttpClient client, HttpContext context, String url,
			IRestKVP[] urlParams, IRestKVP[] headers) throws URISyntaxException 
	{
		super(responseClass, client, context, url, urlParams, headers);
		
		this.scopedBungieNet = scopedBungieNet;
	}

	@Override
	public final IScopedRestRequest<Response> authFailed(Consumer<Void> response) 
	{
		this.authFailed = response;
		
		return this;
	}
	
	@Override
	public final void makeRequest(Consumer<Response> successConsumer, Consumer<IBungieNetError> failConsumer)
	{
		// Renew access token first.
		this.scopedBungieNet.renewAccessToken().fail(error ->
		{
			this.authFailed.accept(null);
			failConsumer.accept(error);
		}).queue(response ->
		{
			super.makeRequest(successConsumer, failConsumer);
		});;
	}
}