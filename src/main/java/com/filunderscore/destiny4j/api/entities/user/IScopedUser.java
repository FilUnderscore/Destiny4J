package com.filunderscore.destiny4j.api.entities.user;

import com.filunderscore.destiny4j.api.entities.user.membership.IUserMembershipData;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IScopedUser extends IUser
{
	IRestRequest<IUserMembershipData> getMembershipData();
}