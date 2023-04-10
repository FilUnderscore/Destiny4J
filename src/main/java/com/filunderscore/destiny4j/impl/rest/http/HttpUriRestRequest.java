package com.filunderscore.destiny4j.impl.rest.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.plexus.util.StringUtils;

import com.filunderscore.destiny4j.api.exceptions.PlatformErrorCodes;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.impl.exceptions.BungieNetAPIError;
import com.filunderscore.destiny4j.impl.rest.RestRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class HttpUriRestRequest<Response, Request extends HttpUriRequest> extends RestRequest<Response>
{
	private final HttpUriRestAPIInjector<Response> restAPIInjector;
	protected static final Gson gson = new Gson();
	
	private final Class<? extends Response> responseClass;
	
	private final HttpUriRestSession session;
	
	private final URI uri;
	private final IRestKVP[] additionalHeaders;
	
	public HttpUriRestRequest(Class<? extends Response> responseClass, HttpUriRestSession session, String url, IRestKVP[] urlParams, IRestKVP[] additionalHeaders)
	{
		this.restAPIInjector = new HttpUriRestAPIInjector<Response>(session);
		this.responseClass = responseClass;

		this.session = session;
		this.additionalHeaders = additionalHeaders;
		
		this.uri = this.createURI(url, urlParams);
	}

	// Build URI.
	private URI createURI(String url, IRestKVP[] urlParams)
	{
		try
		{
			URIBuilder uriBuilder = new URIBuilder(url);
		
			for(IRestKVP kvp : urlParams)
			{
				uriBuilder.setParameter(kvp.getKey(), kvp.getValue());
			}
		
			return uriBuilder.build();
		}
		catch(URISyntaxException e)
		{
			System.err.println(String.format("Failed to create URI '%s' for %s request.", url, this.responseClass.getName()));
		}
		
		return null;
	}
	
	@Override
	public Future<Result> makeRequest()
	{
		return executorService.submit(new Callable<Result>()
		{
			@Override
			public Result call()
			{
				return request();
			}
		});
	}
	
	private Result request()
	{
		Request request = this.setupRequest();
		
		if(request == null)
			return null;
		
		try 
		{
			HttpResponse httpResponse = this.session.getClient().execute(request, this.session.getContext());
			String jsonString = EntityUtils.toString(httpResponse.getEntity());
			
			System.out.println(String.format("%s %s %s", request.getMethod(), this.uri.toString(), StringUtils.abbreviate(jsonString, 1000)));

			JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
			
			int errorCode = json.get("ErrorCode").getAsInt();
			int throttleSeconds = json.get("ThrottleSeconds").getAsInt();
			String errorStatus = json.get("ErrorStatus").getAsString();
			String message = json.get("Message").getAsString();
			
			@SuppressWarnings("unchecked")
			Map<String, String> messageData = (Map<String, String>) gson.fromJson(json.get("MessageData"), Map.class);
			
			PlatformErrorCodes platformErrorCode = PlatformErrorCodes.fromIndex(errorCode);
			
			if(platformErrorCode != PlatformErrorCodes.Success)
			{
				return new Result(new BungieNetAPIError(errorCode, throttleSeconds, errorStatus, message, messageData));
			}
			else
			{
				Response response = gson.fromJson(json.get("Response"), this.responseClass);
				this.restAPIInjector.tryInject(response);
				
				return new Result(response);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	private Request setupRequest()
	{
		if(this.uri == null)
			return null;
		
		Request request = this.createRequest(this.uri);

		for(IRestKVP header : this.session.getSavedHeaders())
		{
			request.setHeader(header.getKey(), header.getValue());
		}
		
		for(IRestKVP header : this.additionalHeaders)
		{
			request.setHeader(header.getKey(), header.getValue());
		}
		
		return request;
	}
	
	protected abstract Request createRequest(URI uri);
}
