package com.filunderscore.destiny4j.impl.rest.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.codehaus.plexus.util.StringUtils;

import com.filunderscore.destiny4j.api.exceptions.PlatformErrorCodes;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.impl.BungieNetAPIError;
import com.filunderscore.destiny4j.impl.rest.RestRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class HttpUriRestRequest<Response, Request extends HttpUriRequest> extends RestRequest<Response>
{
	protected static final Gson gson = new Gson();

	private final Class<? extends Response> responseClass;
	
	private final HttpClient client;
	private final HttpContext context;
	
	private final URI uri;
	private final IRestKVP[] headers;
	
	public HttpUriRestRequest(Class<? extends Response> responseClass, HttpClient client, HttpContext context, String url, IRestKVP[] urlParams, IRestKVP[] headers) throws URISyntaxException
	{
		this.responseClass = responseClass;
		
		this.client = client;
		this.context = context;

		this.headers = headers;
		
		// Build URI.
		
		URIBuilder uriBuilder = new URIBuilder(url);

		for(IRestKVP kvp : urlParams)
		{
			uriBuilder.setParameter(kvp.getKey(), kvp.getValue());
		}
		
		this.uri = uriBuilder.build();
	}
	
	@Override
	public Future<Result> makeRequest()
	{
		return executorService.submit(new Callable<Result>()
		{
			@Override
			public Result call()
			{
				Request request = HttpUriRestRequest.this.setupRequest();
				
				try 
				{
					HttpResponse httpResponse = HttpUriRestRequest.this.client.execute(request, HttpUriRestRequest.this.context);
					String jsonString = EntityUtils.toString(httpResponse.getEntity());
					
					System.out.println(String.format("%s %s %s", request.getMethod(), HttpUriRestRequest.this.uri.toString(), StringUtils.abbreviate(jsonString, 1000)));

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
						return new Result(gson.fromJson(json.get("Response"), HttpUriRestRequest.this.responseClass));
					}
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				
				return null;
			}
		});
	}
	
	private Request setupRequest()
	{
		Request request = this.createRequest(this.uri);

		for(IRestKVP header : this.headers)
		{
			request.setHeader(header.getKey(), header.getValue());
		}
		
		return request;
	}
	
	protected abstract Request createRequest(URI uri);
}
