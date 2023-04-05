package com.filunderscore.destiny4j.impl.entities.user;

import java.util.NoSuchElementException;

import com.filunderscore.destiny4j.api.entities.user.IBungieNetUser;
import com.filunderscore.destiny4j.api.entities.user.IGroupUserInfo;
import com.filunderscore.destiny4j.api.entities.user.membership.IUserMembershipData;

public final class UserMembershipData implements IUserMembershipData
{
	private GroupUser[] destinyMemberships;
	private Long primaryMembershipId;
	private BungieNetUser bungieNetUser;
	
	@Override
	public IGroupUserInfo[] getDestinyMemberships() 
	{
		return this.destinyMemberships;
	}

	@Override
	public IGroupUserInfo getPrimaryMembership() 
	{
		if(this.primaryMembershipId == null)
			return null;
		
		for(IGroupUserInfo info : this.destinyMemberships)
		{
			if(info.getMembershipId() == primaryMembershipId)
			{
				return info;
			}
		}
		
		throw new NoSuchElementException("No associated Destiny memberships match the primary membership.");
	}

	@Override
	public IBungieNetUser getBungieNetUser() 
	{
		return this.bungieNetUser;
	}
}