package com.filunderscore.destiny4j.impl.rest.http;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class JsonHttpUriPostRestRequest<Response, Request> extends StringHttpUriPostRestRequest<Response>
{
	public JsonHttpUriPostRestRequest(Class<? extends Response> responseClass, HttpClient client, HttpContext context,
			String url, IRestKVP[] urlParams, IRestKVP[] headers, Request request) throws URISyntaxException, UnsupportedEncodingException 
	{
		super(responseClass, client, context, url, urlParams, headers, gson.toJson(request));
	}
}