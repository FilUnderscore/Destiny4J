package com.filunderscore.destiny4j.impl.rest.http.auth;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.IBearerScopedBungieNet;
import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class AuthorizedHttpUriPostRestRequest<Response> extends AuthorizedHttpUriRestRequest<Response, HttpPost>
{
	private final HttpEntity entity;
	
	public AuthorizedHttpUriPostRestRequest(IBearerScopedBungieNet scopedBungieNet, Class<Response> responseClass, HttpClient client, HttpContext context, String url, IRestKVP[] urlParams,
			IRestKVP[] headers, HttpEntity entity) throws URISyntaxException 
	{
		super(scopedBungieNet, responseClass, client, context, url, urlParams, headers);
		
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