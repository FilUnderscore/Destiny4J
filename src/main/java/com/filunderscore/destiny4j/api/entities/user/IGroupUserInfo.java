package com.filunderscore.destiny4j.api.entities.user;

import com.filunderscore.destiny4j.api.entities.user.membership.BungieMembershipType;

public interface IGroupUserInfo extends IUserInfo
{
	/**
	 * @return This will be the display name the clan server last saw the user as. 
	 * 
	 * If the account is an active cross save override, this will be the display name to use. 
	 * Otherwise, this will match the displayName property. 
	 */
	String getLastSeenDisplayName();
	
	/**
	 * @return The platform of the LastSeenDisplayName 
	 */
	BungieMembershipType getLastSeenDisplayNameType();
}