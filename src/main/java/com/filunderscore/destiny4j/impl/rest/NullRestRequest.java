package com.filunderscore.destiny4j.impl.rest;

import java.util.function.Consumer;

import com.filunderscore.destiny4j.IBungieNetError;

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
	public void makeRequest(Consumer<Response> successConsumer, Consumer<IBungieNetError> failConsumer)
	{
		successConsumer.accept(this.response);
	}
}