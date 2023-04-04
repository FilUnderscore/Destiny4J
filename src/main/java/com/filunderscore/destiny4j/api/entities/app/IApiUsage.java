package com.filunderscore.destiny4j.api.entities.app;

public interface IApiUsage 
{
	ISeries[] getAPICalls();
	ISeries[] getThrottledRequests();
}