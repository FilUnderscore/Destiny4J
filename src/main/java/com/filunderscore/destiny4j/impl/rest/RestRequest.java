package com.filunderscore.destiny4j.impl.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import com.filunderscore.destiny4j.IBungieNetError;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public abstract class RestRequest<Response> implements IRestRequest<Response>
{
	protected static final ExecutorService executorService = Executors.newCachedThreadPool();
	
	private final List<Consumer<IBungieNetError>> failConsumers = new ArrayList<>();
	private final List<Consumer<Response>> successConsumers = new ArrayList<>();
	
	private final List<RestRequestChainEntry> chainedRequests = new ArrayList<>();

	protected abstract Future<Result> makeRequest();
	
	private Result request()
	{
		try 
		{
			return makeRequest().get();
		} 
		catch (InterruptedException | ExecutionException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	private void finish(Result result)
	{
		if(result.success)
		{
			Response response = result.response;
			
			for(Consumer<Response> successConsumer : this.successConsumers)
			{
				if(successConsumer != null)
					successConsumer.accept(response);
			}
			
			executeChain(true);for(Consumer<Response> successConsumer : this.successConsumers)
			{
				if(successConsumer != null)
					successConsumer.accept(response);
			}
			
			executeChain(true);
		}
		else
		{
			IBungieNetError error = result.error;
			
			for(Consumer<IBungieNetError> failConsumer : this.failConsumers)
			{
				if(failConsumer != null)
					failConsumer.accept(error);
			}
			
			executeChain(false);
		}
	}
	
	@Override
	public final void queue()
	{
		executorService.execute(new Runnable()
		{
			@Override
			public void run()
			{
				finish(request());
			}
		});
	}
	
	@Override
	public final Response execute()
	{
		Result result = request();
		finish(result);
		
		return result.response;
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
	
	protected final class Result
	{
		public final Response response;
		public final IBungieNetError error;
		public final boolean success;
		
		public Result(Response response)
		{
			this.response = response;
			this.error = null;
			this.success = true;
		}
		
		public Result(IBungieNetError error)
		{
			this.response = null;
			this.error = error;
			this.success = false;
		}
	}
}
