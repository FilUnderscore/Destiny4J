package com.filunderscore.destiny4j.api.exceptions;

import java.util.Map;

public interface IBungieNetError 
{
	int getErrorCode();
	int getThrottleSeconds();
	
	String getErrorStatus();
	String getMessage();
	
	Map<String, String> getMessageData();
}