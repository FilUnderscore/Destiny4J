package com.filunderscore.destiny4j.impl.rest.http;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public final class JsonHttpUriPostRestRequest<Response, Request> extends StringHttpUriPostRestRequest<Response>
{
	public JsonHttpUriPostRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session,
			String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders, Request request) throws URISyntaxException, UnsupportedEncodingException 
	{
		super(responseClass, session, url, urlParams, additionalHeaders, gson.toJson(request));
	}
}