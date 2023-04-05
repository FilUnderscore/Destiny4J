package com.filunderscore.destiny4j.impl.rest.http;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public final class UrlEncodedFormHttpUriPostRestRequest<Response> extends HttpUriPostRestRequest<Response>
{
	public UrlEncodedFormHttpUriPostRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session,
			String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders, BasicNameValuePair...params)
			throws URISyntaxException, UnsupportedEncodingException 
	{
		super(responseClass, session, url, urlParams, additionalHeaders, new UrlEncodedFormEntity(Arrays.asList(params)));
	}
}