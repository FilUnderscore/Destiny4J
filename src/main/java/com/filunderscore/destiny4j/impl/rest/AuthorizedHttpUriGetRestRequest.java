package com.filunderscore.destiny4j.impl.rest;

import java.net.URISyntaxException;
import java.util.function.Consumer;

import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.IBearerScopedBungieNet;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.api.rest.scoped.IScopedRestRequest;

public class AuthorizedHttpUriGetRestRequest<Response> extends HttpUriGetRestRequest<Response> implements IScopedRestRequest<Response>
{
	public AuthorizedHttpUriGetRestRequest(Class<Response> responseClass, HttpClient client, HttpContext context,
			String url, IRestKVP[] urlParams, IRestKVP[] headers) throws URISyntaxException 
	{
		super(responseClass, client, context, url, urlParams, headers);
	}

	@Override
	public IScopedRestRequest<Response> authFailed(Consumer<Void> response) 
	{
		return null;
	}

}