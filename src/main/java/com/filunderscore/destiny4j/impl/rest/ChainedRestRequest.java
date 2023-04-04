package com.filunderscore.destiny4j.impl.rest;

import com.filunderscore.destiny4j.api.rest.IRestRequest;

public final class ChainedRestRequest 
{
	@SuppressWarnings("rawtypes")
	public final IRestRequest request;
	public final boolean onSuccess;
	
	public ChainedRestRequest(@SuppressWarnings("rawtypes") IRestRequest request, boolean onSuccess)
	{
		this.request = request;
		this.onSuccess = onSuccess;
	}
}