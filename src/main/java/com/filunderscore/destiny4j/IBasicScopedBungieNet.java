package com.filunderscore.destiny4j;

import com.filunderscore.destiny4j.api.entities.auth.IAccessTokenResponse;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IBasicScopedBungieNet extends IBungieNet
{
	IRestRequest<IAccessTokenResponse> renewAccessToken(String refreshToken);
}