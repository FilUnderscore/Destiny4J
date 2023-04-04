package com.filunderscore.destiny4j.api.entities.auth;

public interface IAccessTokenResponse 
{
	String getAccessToken();
	String getRefreshToken();
	
	long getExpiresIn();
	long getRefreshExpiresIn();
	
	String getTokenType();
	long getMembershipId();
}