package com.filunderscore.destiny4j.impl.rest.http.auth;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.impl.BearerScopedBungieNetAPI;
import com.filunderscore.destiny4j.impl.rest.http.HttpUriRestSession;

public final class AuthorizedJsonHttpUriPostRestRequest<Response, Request> extends AuthorizedStringHttpUriPostRestRequest<Response>
{
	public AuthorizedJsonHttpUriPostRestRequest(BearerScopedBungieNetAPI scopedBungieNet, Class<? extends Response> responseClass, HttpUriRestSession session,
			String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders, Request request) throws URISyntaxException, UnsupportedEncodingException 
	{
		super(scopedBungieNet, responseClass, session, url, urlParams, additionalHeaders, gson.toJson(request));
	}
}