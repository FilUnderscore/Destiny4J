package com.filunderscore.destiny4j.api.entities.app;

public enum ApplicationScopes 
{
	/**
	 * Read basic user profile information such as the user's handle, avatar icon, etc.
	 */
	ReadBasicUserProfile,
	
	/**
	 * Read Group/Clan Forums, Wall, and Members for groups and clans that the user has joined.
	 */
	ReadGroups,
	
	/**
	 * Write Group/Clan Forums, Wall, and Members for groups and clans that the user has joined.
	 */
	WriteGroups,
	
	/**
	 * Administer Group/Clan Forums, Wall, and Members for groups and clans that the user is a founder or an administrator.
	 */
	AdminGroups,
	
	/**
	 * Create new groups, clans, and forum posts, along with other actions that are reserved for Bungie.net elevated scope: not meant to be used by third party applications.
	 */
	BnetWrite,
	
	/**
	 * Move or equip Destiny items
	 */
	MoveEquipDestinyItems,
	
	/**
	 * Read Destiny 1 Inventory and Vault contents. For Destiny 2, this scope is needed to read anything regarded as private. This is the only scope a Destiny 2 app needs for read operations against Destiny 2 data such as inventory, vault, currency, vendors, milestones, progression, etc.
	 */
	ReadDestinyInventoryAndVault,
	
	/**
	 * Read user data such as who they are web notifications, clan/group memberships, recent activity, muted users.
	 */
	ReadUserData,
	
	/**
	 * Edit user data such as preferred language, status, motto, avatar selection and theme.
	 */
	EditUserData,
	
	/**
	 * Access vendor and advisor data specific to a user. OBSOLETE. This scope is only used on the Destiny 1 API.
	 */
	ReadDestinyVendorsAndAdvisors,
	
	/**
	 * Read offer history and claim and apply tokens for the user.
	 */
	ReadAndApplyTokens,
	
	/**
	 * Can perform actions that will result in a prompt to the user via the Destiny app.
	 */
	AdvancedWriteActions,
	
	/**
	 * Can use the partner offer api to claim rewards defined for a partner
	 */
	PartnerOfferGrant,
	
	/**
	 * Allows an app to query sensitive information like unlock flags and values not available through normal methods.
	 */
	DestinyUnlockValueQuery,
	
	/**
	 * Allows an app to query sensitive user PII, most notably email information.
	 */
	UserPiiRead;
}