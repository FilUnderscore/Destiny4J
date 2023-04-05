package com.filunderscore.destiny4j.api.entities.user.membership;

import com.filunderscore.destiny4j.api.entities.user.IBungieNetUser;
import com.filunderscore.destiny4j.api.entities.user.IGroupUserInfo;

public interface IUserMembershipData 
{
	IGroupUserInfo[] getDestinyMemberships();
	IGroupUserInfo getPrimaryMembership();
	
	IBungieNetUser getBungieNetUser();
}