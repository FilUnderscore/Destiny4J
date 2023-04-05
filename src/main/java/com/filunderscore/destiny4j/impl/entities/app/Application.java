package com.filunderscore.destiny4j.impl.entities.app;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

import com.filunderscore.destiny4j.api.entities.app.ApplicationScopes;
import com.filunderscore.destiny4j.api.entities.app.ApplicationStatus;
import com.filunderscore.destiny4j.api.entities.app.IApplication;
import com.filunderscore.destiny4j.api.entities.app.IApplicationDeveloper;

public final class Application implements IApplication
{
	private int applicationId;
	private String name;
	private String redirectUrl;
	private String link;
	private long scope;
	private String origin;
	private int status;
	private Date creationDate;
	private Date statusChanged;
	private Date firstPublished;
	private ApplicationDeveloper[] team;
	private String overrideAuthorizeViewName;
	
	@Override
	public int getApplicationId() 
	{
		return this.applicationId;
	}

	@Override
	public String getApplicationName() 
	{
		return this.name;
	}

	@Override
	public String getRedirectURL() 
	{
		return this.redirectUrl;
	}

	@Override
	public String getLink() 
	{
		return this.link;
	}

	@Override
	public Set<ApplicationScopes> getScopes() 
	{
		ApplicationScopes[] values = ApplicationScopes.values();
		Set<ApplicationScopes> set = EnumSet.noneOf(ApplicationScopes.class);
		
		for(int i = 0; i < values.length; i++)
		{
			boolean bitSet = (((1L << i) & this.scope) >> i) != 0L;
			
			if(bitSet)
				set.add(values[i]);
		}
		
		return set;
	}

	@Override
	public String getOrigin() 
	{
		return this.origin;
	}

	@Override
	public ApplicationStatus getStatus() 
	{
		return ApplicationStatus.values()[this.status];
	}

	@Override
	public Date getCreationDate() 
	{
		return this.creationDate;
	}

	@Override
	public Date getStatusChanged() 
	{
		return this.statusChanged;
	}

	@Override
	public Date getFirstPublished() 
	{
		return this.firstPublished;
	}

	@Override
	public IApplicationDeveloper[] getTeam() 
	{
		return this.team;
	}

	@Override
	public String getOverrideAuthorizeViewName() 
	{
		return this.overrideAuthorizeViewName;
	}
}