package com.filunderscore.destiny4j.impl.rest.http.auth;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;

import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.impl.BearerScopedBungieNetAPI;
import com.filunderscore.destiny4j.impl.rest.http.HttpUriRestSession;

public class AuthorizedHttpUriPostRestRequest<Response> extends AuthorizedHttpUriRestRequest<Response, HttpPost>
{
	private final HttpEntity entity;
	
	public AuthorizedHttpUriPostRestRequest(BearerScopedBungieNetAPI scopedBungieNet, Class<? extends Response> responseClass, HttpUriRestSession session, String url, IRestKVP[] urlParams,
			IRestKVP[] additionalHeaders, HttpEntity entity)
	{
		super(scopedBungieNet, responseClass, session, url, urlParams, additionalHeaders);
		
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