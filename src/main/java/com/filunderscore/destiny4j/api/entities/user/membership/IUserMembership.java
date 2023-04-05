package com.filunderscore.destiny4j.api.entities.user.membership;

public interface IUserMembership 
{
	BungieMembershipType getMembershipType();

	long getMembershipId();
	String getDisplayName();
	
	String getBungieGlobalDisplayName();
	Short getBungieGlobalDisplayNameCode();
}