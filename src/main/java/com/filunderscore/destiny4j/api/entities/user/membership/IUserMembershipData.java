package com.filunderscore.destiny4j.api.entities.user.membership;

import com.filunderscore.destiny4j.api.entities.user.IBungieNetUser;
import com.filunderscore.destiny4j.api.entities.user.IGroupUserInfo;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IUserMembershipData 
{
	IGroupUserInfo[] getDestinyMemberships();

	IRestRequest<IGroupUserInfo> getPrimaryMembership();
	
	IBungieNetUser getBungieNetUser();
}