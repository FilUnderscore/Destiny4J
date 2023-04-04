package com.filunderscore.destiny4j.impl.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.codehaus.plexus.util.StringUtils;

import com.filunderscore.destiny4j.IBungieNetError;
import com.filunderscore.destiny4j.api.exceptions.PlatformErrorCodes;
import com.filunderscore.destiny4j.api.rest.IRestKVP;
import com.filunderscore.destiny4j.impl.BungieNetAPIError;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class HttpUriRestRequest<Response, Request extends HttpUriRequest> extends RestRequest<Response>
{
	protected static final Gson gson = new Gson();

	private final Class<Response> responseClass;
	
	private final HttpClient client;
	private final HttpContext context;
	
	private final URI uri;
	private final IRestKVP[] headers;
	
	public HttpUriRestRequest(Class<Response> responseClass, HttpClient client, HttpContext context, String url, IRestKVP[] urlParams, IRestKVP[] headers) throws URISyntaxException
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
	public void makeRequest(Consumer<Response> successConsumer, Consumer<IBungieNetError> failConsumer)
	{
		Request request = this.setupRequest();
		
		try 
		{
			HttpResponse httpResponse = this.client.execute(request, this.context);
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
				failConsumer.accept(new BungieNetAPIError(errorCode, throttleSeconds, errorStatus, message, messageData));
			}
			else
			{
				successConsumer.accept(gson.fromJson(json.get("Response"), this.responseClass));
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
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
