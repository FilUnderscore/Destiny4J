package com.filunderscore.destiny4j.impl.rest.http;

import java.net.URI;

import org.apache.http.client.methods.HttpGet;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class HttpUriGetRestRequest<Response> extends HttpUriRestRequest<Response, HttpGet>
{
	public HttpUriGetRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session, String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders) 
	{
		super(responseClass, session, url, urlParams, additionalHeaders);
	}
	
	public HttpUriGetRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session, String url) 
	{
		super(responseClass, session, url, new IRestKVP[0], new IRestKVP[0]);
	}

	@Override
	protected HttpGet createRequest(URI uri) 
	{
		return new HttpGet(uri);
	}
}