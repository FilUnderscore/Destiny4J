package com.filunderscore.destiny4j.api.entities.user.membership;

import java.util.Set;

public interface ICrossSaveUserMembership extends IUserMembership
{
	BungieMembershipType getCrossSaveOverride();
	Set<BungieMembershipType> getApplicableMembershipType();
	
	boolean isPublic();
}