package com.filunderscore.destiny4j.impl.rest.http;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class StringHttpUriPostRestRequest<Response> extends HttpUriPostRestRequest<Response>
{
	public StringHttpUriPostRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session,
			String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders, String entity)
	{
		super(responseClass, session, url, urlParams, additionalHeaders, createEntity(entity, responseClass));
	}
	
	private static HttpEntity createEntity(String entity, Class<?> responseClass)
	{
		try
		{
			return new StringEntity(entity);
		}
		catch(UnsupportedEncodingException e)
		{
			System.err.println(String.format("An invalid string entity could not be encoded for a POST REST request for a %s, response returned may be invalid.", responseClass.getSimpleName()));
		}
		
		return null;
	}
}