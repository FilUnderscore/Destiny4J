package com.filunderscore.destiny4j.impl.rest.http;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public final class UrlEncodedFormHttpUriPostRestRequest<Response> extends HttpUriPostRestRequest<Response>
{
	public UrlEncodedFormHttpUriPostRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session,
			String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders, BasicNameValuePair...params) 
	{
		super(responseClass, session, url, urlParams, additionalHeaders, createEntity(params, responseClass));
	}
	
	private static HttpEntity createEntity(BasicNameValuePair[] params, Class<?> responseClass)
	{
		try
		{
			return new UrlEncodedFormEntity(Arrays.asList(params));
		}
		catch(UnsupportedEncodingException e)
		{
			System.err.println(String.format("An invalid x-www-form-urlencoded entity could not be encoded for a post REST request for a %s, response returned may be invalid.", responseClass.getSimpleName()));
		}
		
		return null;
	}
}