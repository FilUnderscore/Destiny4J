package com.filunderscore.destiny4j.impl.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class HttpUriGetRestRequest<Response> extends HttpUriRestRequest<Response, HttpGet>
{
	public HttpUriGetRestRequest(Class<Response> responseClass, HttpClient client, HttpContext context, String url, IRestKVP[] urlParams,
			IRestKVP[] headers) throws URISyntaxException 
	{
		super(responseClass, client, context, url, urlParams, headers);
	}

	@Override
	protected HttpGet createRequest(URI uri) 
	{
		return new HttpGet(uri);
	}
}