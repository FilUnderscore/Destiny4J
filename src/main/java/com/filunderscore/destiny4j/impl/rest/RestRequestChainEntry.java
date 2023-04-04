package com.filunderscore.destiny4j.impl.rest;

import com.filunderscore.destiny4j.api.rest.IRestRequest;

public final class RestRequestChainEntry 
{
	@SuppressWarnings("rawtypes")
	public final IRestRequest request;
	public final boolean onSuccess;
	
	public RestRequestChainEntry(@SuppressWarnings("rawtypes") IRestRequest request, boolean onSuccess)
	{
		this.request = request;
		this.onSuccess = onSuccess;
	}
}