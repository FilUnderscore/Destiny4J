package com.filunderscore.destiny4j.impl.rest.http.auth;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.IBearerScopedBungieNet;
import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class AuthorizedJsonHttpUriPostRestRequest<Response, Request> extends AuthorizedStringHttpUriPostRestRequest<Response>
{
	public AuthorizedJsonHttpUriPostRestRequest(IBearerScopedBungieNet scopedBungieNet, Class<Response> responseClass, HttpClient client, HttpContext context,
			String url, IRestKVP[] urlParams, IRestKVP[] headers, Request request) throws URISyntaxException, UnsupportedEncodingException 
	{
		super(scopedBungieNet, responseClass, client, context, url, urlParams, headers, gson.toJson(request));
	}
}