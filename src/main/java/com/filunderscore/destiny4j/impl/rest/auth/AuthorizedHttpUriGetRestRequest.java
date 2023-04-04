package com.filunderscore.destiny4j.impl.rest.auth;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.IBearerScopedBungieNet;
import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class AuthorizedHttpUriGetRestRequest<Response> extends AuthorizedHttpUriRestRequest<Response, HttpGet>
{
	public AuthorizedHttpUriGetRestRequest(IBearerScopedBungieNet scopedBungieNet, Class<Response> responseClass,
			HttpClient client, HttpContext context, String url, IRestKVP[] urlParams, IRestKVP[] headers)
			throws URISyntaxException 
	{
		super(scopedBungieNet, responseClass, client, context, url, urlParams, headers);
	}

	@Override
	protected HttpGet createRequest(URI uri) 
	{
		return new HttpGet(uri);
	}
}