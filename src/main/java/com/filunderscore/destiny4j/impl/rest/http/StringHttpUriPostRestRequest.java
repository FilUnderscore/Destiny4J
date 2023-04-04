package com.filunderscore.destiny4j.impl.rest.http;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class StringHttpUriPostRestRequest<Response> extends HttpUriPostRestRequest<Response>
{
	public StringHttpUriPostRestRequest(Class<Response> responseClass, HttpClient client,
			HttpContext context, String url, IRestKVP[] urlParams, IRestKVP[] headers, String entity)
			throws URISyntaxException, UnsupportedEncodingException 
	{
		super(responseClass, client, context, url, urlParams, headers, new StringEntity(entity));
	}
}