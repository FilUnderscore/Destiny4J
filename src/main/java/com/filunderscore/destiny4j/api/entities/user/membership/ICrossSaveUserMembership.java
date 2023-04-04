package com.filunderscore.destiny4j.api.entities.user.membership;

import java.util.Set;

import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface ICrossSaveUserMembership extends IUserMembership
{
	IRestRequest<IUserMembership> getCrossSaveOverride();
	Set<BungieMembershipType> getApplicableMembershipType();
	
	boolean isPublic();
}