package com.filunderscore.destiny4j;

import com.filunderscore.destiny4j.api.entities.app.IApiUsage;
import com.filunderscore.destiny4j.api.entities.auth.IAccessTokenResponse;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IBearerScopedBungieNet extends IBasicScopedBungieNet
{
	IRestRequest<IAccessTokenResponse> renewAccessToken();
	
	/**
	 * GET: /App/ApiUsage/
	 * <br><br>
	 * 
	 * Get API usage by application for time frame specified. 
	 * You can go as far back as 30 days ago, and can ask for 
	 * up to a 48 hour window of time in a single request. 
	 * 
	 * You must be authenticated with at least the ReadUserData 
	 * permission to access this endpoint.
	 * 
	 * @return API usage of the current application.
	 */
	IRestRequest<IApiUsage> getApplicationApiUsage();
	
	/**
	 * GET: /App/ApiUsage/{applicationId}/
	 * <br><br>
	 * 
	 * Get API usage by application for time frame specified. 
	 * You can go as far back as 30 days ago, and can ask for 
	 * up to a 48 hour window of time in a single request. 
	 * 
	 * You must be authenticated with at least the ReadUserData 
	 * permission to access this endpoint.
	 * 
	 * @param applicationId ID of the application to get usage statistics.
	 * 
	 * @return API usage of the specified application ID.
	 */
	IRestRequest<IApiUsage> getApplicationApiUsage(int applicationId);
}