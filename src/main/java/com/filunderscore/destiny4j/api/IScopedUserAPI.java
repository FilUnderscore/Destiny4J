package com.filunderscore.destiny4j.api;

import com.filunderscore.destiny4j.api.entities.user.membership.IUserMembershipData;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IScopedUserAPI extends IUserAPI
{
	IRestRequest<IUserMembershipData> getMembershipDataForCurrentUser();
}