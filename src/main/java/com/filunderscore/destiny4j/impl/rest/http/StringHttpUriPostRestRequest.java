package com.filunderscore.destiny4j.impl.rest.http;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.apache.http.entity.StringEntity;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class StringHttpUriPostRestRequest<Response> extends HttpUriPostRestRequest<Response>
{
	public StringHttpUriPostRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session,
			String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders, String entity)
			throws URISyntaxException, UnsupportedEncodingException 
	{
		super(responseClass, session, url, urlParams, additionalHeaders, new StringEntity(entity));
	}
}