package com.filunderscore.destiny4j.impl.rest.http.auth;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.apache.http.entity.StringEntity;

import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.impl.BearerScopedBungieNetAPI;
import com.filunderscore.destiny4j.impl.rest.http.HttpUriRestSession;

public class AuthorizedStringHttpUriPostRestRequest<Response> extends AuthorizedHttpUriPostRestRequest<Response>
{
	public AuthorizedStringHttpUriPostRestRequest(BearerScopedBungieNetAPI scopedBungieNet, Class<? extends Response> responseClass, HttpUriRestSession session,
			String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders, String entity)
			throws URISyntaxException, UnsupportedEncodingException 
	{
		super(scopedBungieNet, responseClass, session, url, urlParams, additionalHeaders, new StringEntity(entity));
	}
}