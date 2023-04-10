package com.filunderscore.destiny4j.api.events;

import com.filunderscore.destiny4j.api.entities.auth.IAccessTokenResponse;

public interface IAccessTokenResponseEvent
{
	void onAccessTokenResponse(IAccessTokenResponse response);
}