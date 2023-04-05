package com.filunderscore.destiny4j.impl.rest.http;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class HttpUriPostRestRequest<Response> extends HttpUriRestRequest<Response, HttpPost>
{
	private final HttpEntity entity;
	
	public HttpUriPostRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session, String url, IRestKVP[] urlParams,
			IRestKVP[] additionalHeaders, HttpEntity entity) throws URISyntaxException 
	{
		super(responseClass, session, url, urlParams, additionalHeaders);
		
		this.entity = entity;
	}

	@Override
	protected HttpPost createRequest(URI uri) 
	{
		HttpPost post = new HttpPost(uri);
		
		post.setEntity(this.entity);
		
		return post;
	}
}