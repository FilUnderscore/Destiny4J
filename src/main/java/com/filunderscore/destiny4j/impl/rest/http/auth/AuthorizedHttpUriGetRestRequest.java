package com.filunderscore.destiny4j.impl.rest.http.auth;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpGet;

import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.impl.BearerScopedBungieNetAPI;
import com.filunderscore.destiny4j.impl.rest.http.HttpUriRestSession;

public class AuthorizedHttpUriGetRestRequest<Response> extends AuthorizedHttpUriRestRequest<Response, HttpGet>
{
	public AuthorizedHttpUriGetRestRequest(BearerScopedBungieNetAPI scopedBungieNet, Class<? extends Response> responseClass,
			HttpUriRestSession session, String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders)
			throws URISyntaxException 
	{
		super(scopedBungieNet, responseClass, session, url, urlParams, additionalHeaders);
	}

	@Override
	protected HttpGet createRequest(URI uri) 
	{
		return new HttpGet(uri);
	}
}