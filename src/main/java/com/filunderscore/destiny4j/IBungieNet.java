package com.filunderscore.destiny4j;

import java.util.Map;

import com.filunderscore.destiny4j.api.entities.app.IApplication;
import com.filunderscore.destiny4j.api.entities.manifest.IDestinyManifest;
import com.filunderscore.destiny4j.api.entities.manifest.IManifestEntity;
import com.filunderscore.destiny4j.api.entities.user.IBungieNetUser;
import com.filunderscore.destiny4j.api.entities.user.IUser;
import com.filunderscore.destiny4j.api.entities.user.membership.BungieMembershipType;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IBungieNet 
{	
	/**
	 * GET: /App/FirstParty/
	 * 
	 * @return Get list of applications created by Bungie.
	 */
	IRestRequest<IApplication[]> getBungieApplications();
	
	/**
	 * GET: /Destiny2/Manifest/
	 * 
	 * @return Returns the current version of the manifest as an IDestinyManifest object.
	 */
	IRestRequest<IDestinyManifest> getDestinyManifest();
	
	/**
	 * GET: /Destiny2/Manifest/{entityType}/{hashIdentifier}/
	 * <br><br>
	 * 
	 * Returns the static definition of an entity of the given Type and hash identifier. 
	 * 
	 * Examine the API Documentation for the Type Names of entities that have their own 
	 * definitions. 
	 * 
	 * Note that the return type will always *inherit from* DestinyDefinition, but the 
	 * specific type returned will be the requested entity type if it can be found. 
	 * 
	 * Please don't use this as a chatty alternative to the Manifest database if you require 
	 * large sets of data, but for simple and one-off accesses this should be handy.
	 * 
	 * @param <T> Class type that inherits IManifestEntity.
	 * @param entityType The type of entity for whom you would like results. These correspond to the entity's definition contract name. For instance, if you are looking for items, this property should be 'DestinyInventoryItemDefinition'. PREVIEW: This endpoint is still in beta, and may experience rough edges. The schema is tentatively in final form, but there may be bugs that prevent desirable operation.
	 * @param hashIdentifier The hash identifier for the specific Entity you want returned.
	 * @return
	 */
	<T extends IManifestEntity> IRestRequest<T> getDestinyEntityDefinition(Class<T> entityType, long hashIdentifier);
	
	IRestRequest<IUser[]> searchDestinyPlayerByBungieName(BungieMembershipType type, String displayName, byte displayNameCode);
	
	IRestRequest<IBungieNetUser> getBungieNetUserById(long membershipId);
	IRestRequest<Map<String, Byte>> getSanitizedPlatformDisplayNames(long membershipId);

	// TODO: Get Credential Types for Target Account
}