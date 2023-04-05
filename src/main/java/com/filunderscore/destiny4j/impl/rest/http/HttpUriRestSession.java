package com.filunderscore.destiny4j.impl.rest.http;

import java.util.Arrays;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HttpContext;

import com.filunderscore.destiny4j.api.rest.IRestAPI;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.api.rest.IRestSession;

public class HttpUriRestSession implements IRestSession
{
	private final IRestAPI api;
	private final HttpClient client;
	private final HttpContext context;
	private final List<IRestKVP> savedHeaders;
	
	public HttpUriRestSession(IRestAPI api, HttpClient client, HttpContext context, IRestKVP[] savedHeaders)
	{
		this.api = api;
		this.client = client;
		this.context = context;
		this.savedHeaders = Arrays.asList(savedHeaders);
	}
	
	public IRestAPI getAPI()
	{
		return this.api;
	}

	public HttpClient getClient()
	{
		return this.client;
	}
	
	public HttpContext getContext()
	{
		return this.context;
	}
	
	public IRestKVP[] getSavedHeaders()
	{
		return this.savedHeaders.toArray(size -> new IRestKVP[size]);
	}
}