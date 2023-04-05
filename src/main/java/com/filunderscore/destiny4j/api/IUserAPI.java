package com.filunderscore.destiny4j.api;

import java.util.Map;

import com.filunderscore.destiny4j.api.entities.user.IBungieNetUser;
import com.filunderscore.destiny4j.api.entities.user.membership.IHardLinkedUserMembership;
import com.filunderscore.destiny4j.api.entities.user.membership.IUserMembershipData;
import com.filunderscore.destiny4j.api.rest.IRestAPI;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IUserAPI extends IRestAPI
{
	IRestRequest<IBungieNetUser> getBungieNetUserById(long membershipId);

	IRestRequest<Map<String, Byte>> getSanitizedPlatformDisplayNames(long membershipId);
	
	IRestRequest<?> getCredentialTypesForTargetAccount(long membershipId);
	
	IRestRequest<?> getAvailableThemes();
	
	IRestRequest<IUserMembershipData> getMembershipDataById(long membershipId, int membershipType);
	
	IRestRequest<IHardLinkedUserMembership> getMembershipFromHardLinkedCredential(String credential, byte crType);
	
	IRestRequest<?> searchByGlobalNamePost(int page, String displayNamePrefix);
}