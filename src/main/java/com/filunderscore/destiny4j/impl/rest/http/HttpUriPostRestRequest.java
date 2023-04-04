package com.filunderscore.destiny4j.impl.rest.http;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class HttpUriPostRestRequest<Response> extends HttpUriRestRequest<Response, HttpPost>
{
	private final HttpEntity entity;
	
	public HttpUriPostRestRequest(Class<Response> responseClass, HttpClient client, HttpContext context, String url, IRestKVP[] urlParams,
			IRestKVP[] headers, HttpEntity entity) throws URISyntaxException 
	{
		super(responseClass, client, context, url, urlParams, headers);
		
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