package com.filunderscore.destiny4j.api.entities.user;

import com.filunderscore.destiny4j.api.entities.user.membership.BungieMembershipType;
import com.filunderscore.destiny4j.api.entities.user.membership.IUserMembershipData;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IUser extends IUserInfo
{
	IRestRequest<IUserMembershipData> getMembershipData(BungieMembershipType type);
	IRestRequest<IUserMembershipData> getMembershipData();
}