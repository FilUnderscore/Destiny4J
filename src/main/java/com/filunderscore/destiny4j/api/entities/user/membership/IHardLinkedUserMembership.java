package com.filunderscore.destiny4j.api.entities.user.membership;

import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IHardLinkedUserMembership 
{
	BungieMembershipType getMembershipType();
	long getMembershipId();
	
	IRestRequest<IUserMembership> getMembership();
	IRestRequest<IUserMembership> getCrossSaveOverriddenMembership();
}