package com.filunderscore.destiny4j.impl.entities.user;

import com.filunderscore.destiny4j.api.entities.user.IGroupUserInfo;
import com.filunderscore.destiny4j.api.entities.user.membership.BungieMembershipType;

public class GroupUser extends User implements IGroupUserInfo
{
	private String LastSeenDisplayName;
	private int LastSeenDisplayNameType;
	
	@Override
	public String getLastSeenDisplayName() 
	{
		return this.LastSeenDisplayName;
	}
	
	@Override
	public BungieMembershipType getLastSeenDisplayNameType() 
	{
		return BungieMembershipType.fromIndex(this.LastSeenDisplayNameType);
	}
}