package net.bungie.api.user;

public class ExactSearchRequest 
{
	public final String displayName;
	public final short displayNameCode;
	
	public ExactSearchRequest(String displayName, short displayNameCode)
	{
		this.displayName = displayName;
		this.displayNameCode = displayNameCode;
	}
}