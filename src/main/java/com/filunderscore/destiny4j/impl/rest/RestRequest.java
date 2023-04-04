package com.filunderscore.destiny4j.impl.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.filunderscore.destiny4j.IBungieNetError;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public abstract class RestRequest<Response> implements IRestRequest<Response>
{
	private final List<Consumer<IBungieNetError>> failConsumers = new ArrayList<>();
	private final List<Consumer<Response>> successConsumers = new ArrayList<>();
	
	private final List<RestRequestChainEntry> chainedRequests = new ArrayList<>();

	public abstract void makeRequest(Consumer<Response> successConsumer, Consumer<IBungieNetError> failConsumer);
	
	@Override
	public final void queue()
	{
		makeRequest(response ->
		{
			for(Consumer<Response> successConsumer : this.successConsumers)
			{
				if(successConsumer != null)
					successConsumer.accept(response);
			}
			
			executeChain(true);
		}, error ->
		{
			for(Consumer<IBungieNetError> failConsumer : this.failConsumers)
			{
				if(failConsumer != null)
					failConsumer.accept(error);
			}
			
			executeChain(false);
		});
	}
	
	private void executeChain(boolean success)
	{
		for(RestRequestChainEntry chainedRequest : this.chainedRequests)
		{
			if((chainedRequest.onSuccess && !success) || chainedRequest.request == null)
				continue;
			
			chainedRequest.request.queue();
		}
	}
	
	@Override
	public final void queue(Consumer<Response> response) 
	{
		this.success(response).queue();
	}

	@Override
	public final IRestRequest<Response> fail(Consumer<IBungieNetError> response) 
	{
		this.failConsumers.add(response);
		
		return this;
	}

	@Override
	public final IRestRequest<Response> success(Consumer<Response> response) 
	{
		this.successConsumers.add(response);
		
		return this;
	}

	@Override
	public final IRestRequest<Response> chain(@SuppressWarnings("rawtypes") IRestRequest request) 
	{
		this.chainedRequests.add(new RestRequestChainEntry(request, false));
		
		return this;
	}

	@Override
	public final IRestRequest<Response> chainOnSuccess(@SuppressWarnings("rawtypes") IRestRequest request) 
	{
		this.chainedRequests.add(new RestRequestChainEntry(request, true));
		
		return this;
	}
}
