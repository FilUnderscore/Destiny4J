package com.filunderscore.destiny4j.api.entities.app;

import com.filunderscore.destiny4j.api.entities.user.IUser;
import com.filunderscore.destiny4j.api.rest.IRestEntity;

public interface IApplicationDeveloper extends IRestEntity 
{
	DeveloperRole getRole();
	int getAPIEulaVersion();
	
	IUser getUser();
}