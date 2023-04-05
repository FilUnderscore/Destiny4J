package com.filunderscore.destiny4j.api;

import com.filunderscore.destiny4j.api.entities.auth.IAccessTokenResponse;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IOAuth2API 
{
	IRestRequest<IAccessTokenResponse> renewAccessToken(String refreshToken);
	IRestRequest<IAccessTokenResponse> renewAccessToken();
}