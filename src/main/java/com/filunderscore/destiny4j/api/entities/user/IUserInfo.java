package com.filunderscore.destiny4j.api.entities.user;

import com.filunderscore.destiny4j.api.entities.user.membership.ICrossSaveUserMembership;

/**
 * This contract supplies basic information commonly used 
 * to display a minimal amount of information about a user. 
 * 
 * Take care to not add more properties here unless the property 
 * applies in all (or at least the majority) of the situations where 
 * UserInfoCard is used. 
 * 
 * Avoid adding game specific or platform specific details here. 
 * In cases where UserInfoCard is a subset of the data needed in a contract, 
 * use UserInfoCard as a property of other contracts. 
 */
public interface IUserInfo extends ICrossSaveUserMembership
{
	/**
	 * @return A platform specific additional display name - ex: psn Real Name, bnet Unique Name, etc. 
	 */
	String getSupplementalDisplayName();
	
	/**
	 * @return URL the Icon if available. 
	 */
	String getIconPath();
}