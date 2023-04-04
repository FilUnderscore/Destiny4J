package com.filunderscore.destiny4j.api.entities.app;

public enum ApplicationStatus 
{
	/**
	 * No value assigned
	 */
	None,
	
	/**
	 * Application exists and works but will not appear in any public catalog. New applications start in this state, test applications will remain in this state.
	 */
	Private,
	
	/**
	 * Active applications that can appear in an catalog.
	 */
	Public,
	
	/**
	 * Application disabled by the owner. All authorizations will be treated as terminated while in this state. Owner can move back to private or public state.
	 */
	Disabled,
	
	/**
	 * Application has been blocked by Bungie. It cannot be transitioned out of this state by the owner. Authorizations are terminated when an application is in this state.
	 */
	Blocked;
}