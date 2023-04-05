package com.filunderscore.destiny4j.impl.entities.user;

import com.filunderscore.destiny4j.api.IScopedUserAPI;
import com.filunderscore.destiny4j.api.annotations.InjectAPI;
import com.filunderscore.destiny4j.api.entities.user.IScopedUser;
import com.filunderscore.destiny4j.api.entities.user.membership.IUserMembershipData;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public final class ScopedUser extends User implements IScopedUser
{
	@InjectAPI
	protected IScopedUserAPI scopedUserAPI;
	
	@Override
	public IRestRequest<IUserMembershipData> getMembershipData()
	{
		return this.scopedUserAPI.getMembershipDataForCurrentUser();
	}
}