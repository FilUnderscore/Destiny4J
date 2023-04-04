package com.filunderscore.destiny4j.impl.rest.http.auth;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.IBearerScopedBungieNet;
import com.filunderscore.destiny4j.api.rest.IRestKVP;

public class AuthorizedStringHttpUriPostRestRequest<Response> extends AuthorizedHttpUriPostRestRequest<Response>
{
	public AuthorizedStringHttpUriPostRestRequest(IBearerScopedBungieNet scopedBungieNet, Class<? extends Response> responseClass, HttpClient client,
			HttpContext context, String url, IRestKVP[] urlParams, IRestKVP[] headers, String entity)
			throws URISyntaxException, UnsupportedEncodingException 
	{
		super(scopedBungieNet, responseClass, client, context, url, urlParams, headers, new StringEntity(entity));
	}
}