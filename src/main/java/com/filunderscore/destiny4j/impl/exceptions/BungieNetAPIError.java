package com.filunderscore.destiny4j.impl.exceptions;

import java.util.Map;

import com.filunderscore.destiny4j.api.exceptions.IBungieNetError;

public final class BungieNetAPIError implements IBungieNetError
{
	private final int errorCode;
	private final int throttleSeconds;
	private final String errorStatus;
	private final String message;
	private final Map<String, String> messageData;
	
	public BungieNetAPIError(int errorCode, int throttleSeconds, String errorStatus, String message, Map<String, String> messageData)
	{
		this.errorCode = errorCode;
		this.throttleSeconds = throttleSeconds;
		this.errorStatus = errorStatus;
		this.message = message;
		this.messageData = messageData;
	}

	@Override
	public int getErrorCode() 
	{
		return this.errorCode;
	}

	@Override
	public int getThrottleSeconds() 
	{
		return this.throttleSeconds;
	}

	@Override
	public String getErrorStatus() 
	{
		return this.errorStatus;
	}

	@Override
	public String getMessage() 
	{
		return this.message;
	}

	@Override
	public Map<String, String> getMessageData() 
	{
		return this.messageData;
	}
}