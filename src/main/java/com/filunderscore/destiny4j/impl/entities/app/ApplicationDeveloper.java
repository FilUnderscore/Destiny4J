package com.filunderscore.destiny4j.impl.entities.app;

import com.filunderscore.destiny4j.api.entities.app.DeveloperRole;
import com.filunderscore.destiny4j.api.entities.app.IApplicationDeveloper;
import com.filunderscore.destiny4j.api.entities.user.IUser;
import com.filunderscore.destiny4j.impl.entities.user.User;

public final class ApplicationDeveloper implements IApplicationDeveloper
{
	private int role;
	private int apiEulaVersion;
	private User user;
	
	@Override
	public DeveloperRole getRole() 
	{
		return DeveloperRole.values()[role];
	}

	@Override
	public int getAPIEulaVersion() 
	{
		return this.apiEulaVersion;
	}

	@Override
	public IUser getUser() 
	{
		return this.user;
	}
}