package com.filunderscore.destiny4j.impl.rest.http;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpGet;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class HttpUriGetRestRequest<Response> extends HttpUriRestRequest<Response, HttpGet>
{
	public HttpUriGetRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session, String url, IRestKVP[] urlParams,
			IRestKVP[] additionalHeaders) throws URISyntaxException 
	{
		super(responseClass, session, url, urlParams, additionalHeaders);
	}

	@Override
	protected HttpGet createRequest(URI uri) 
	{
		return new HttpGet(uri);
	}
}