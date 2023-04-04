package com.filunderscore.destiny4j.impl.rest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public final class NullRestRequest<Response> extends RestRequest<Response>
{
	private final Response response;
	
	public NullRestRequest(Response response)
	{
		this.response = response;
	}
	
	public NullRestRequest()
	{
		this(null);
	}

	@Override
	protected Future<Result> makeRequest() 
	{
		return CompletableFuture.completedFuture(new Result(this.response));
	}
}