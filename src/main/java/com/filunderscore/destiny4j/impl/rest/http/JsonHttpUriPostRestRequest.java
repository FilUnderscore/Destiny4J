package com.filunderscore.destiny4j.impl.rest.http;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public final class JsonHttpUriPostRestRequest<Response, Request> extends StringHttpUriPostRestRequest<Response>
{
	public JsonHttpUriPostRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session,
			String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders, Request request) 
	{
		super(responseClass, session, url, urlParams, additionalHeaders, gson.toJson(request));
	}
	
	public JsonHttpUriPostRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session,
			String url, Request request) 
	{
		this(responseClass, session, url, new IRestKVP[0], new IRestKVP[0], request);
	}
}