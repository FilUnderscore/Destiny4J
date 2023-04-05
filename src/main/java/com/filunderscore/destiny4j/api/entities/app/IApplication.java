package com.filunderscore.destiny4j.api.entities.app;

import java.util.Date;
import java.util.Set;

import com.filunderscore.destiny4j.api.rest.IRestEntity;

public interface IApplication extends IRestEntity 
{
	int getApplicationId();
	String getApplicationName();
	
	String getRedirectURL();
	String getLink();
	
	Set<ApplicationScopes> getScopes();
	
	String getOrigin();
	ApplicationStatus getStatus();
	
	Date getCreationDate();
	Date getStatusChanged();
	Date getFirstPublished();
	
	IApplicationDeveloper[] getTeam();
	
	String getOverrideAuthorizeViewName();
}