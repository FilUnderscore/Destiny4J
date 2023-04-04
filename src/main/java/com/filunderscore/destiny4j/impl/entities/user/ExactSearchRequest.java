package com.filunderscore.destiny4j.impl.entities.user;

public final class ExactSearchRequest 
{
	public final String displayName;
	public final short displayNameCode;
	
	public ExactSearchRequest(String displayName, short displayNameCode)
	{
		this.displayName = displayName;
		this.displayNameCode = displayNameCode;
	}
}