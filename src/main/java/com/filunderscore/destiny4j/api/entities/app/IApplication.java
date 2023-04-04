package com.filunderscore.destiny4j.api.entities.app;

import java.util.Date;
import java.util.Set;

public interface IApplication 
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