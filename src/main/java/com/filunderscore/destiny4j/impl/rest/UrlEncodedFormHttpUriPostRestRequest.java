package com.filunderscore.destiny4j.impl.rest;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class UrlEncodedFormHttpUriPostRestRequest<Response> extends HttpUriPostRestRequest<Response>
{
	public UrlEncodedFormHttpUriPostRestRequest(Class<Response> responseClass, HttpClient client,
			HttpContext context, String url, IRestKVP[] urlParams, IRestKVP[] headers, BasicNameValuePair...params)
			throws URISyntaxException, UnsupportedEncodingException 
	{
		super(responseClass, client, context, url, urlParams, headers, new UrlEncodedFormEntity(Arrays.asList(params)));
	}
}