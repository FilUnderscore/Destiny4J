package com.filunderscore.destiny4j.api.entities.app;

import com.filunderscore.destiny4j.api.entities.user.IUser;

public interface IApplicationDeveloper 
{
	DeveloperRole getRole();
	int getAPIEulaVersion();
	
	IUser getUser();
}