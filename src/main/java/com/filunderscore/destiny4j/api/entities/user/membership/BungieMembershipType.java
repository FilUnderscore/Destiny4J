package com.filunderscore.destiny4j.api.entities.user.membership;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * The types of membership the Accounts system supports. 
 * 
 * This is the external facing enum used in place of the 
 * internal-only Bungie.SharedDefinitions.MembershipType. 
 */
public enum BungieMembershipType 
{
	None,
	TigerXbox,
	TigerPsn,
	TigerSteam,
	TigerBlizzard,
	TigerStadia,
	TigerEgs,
	TigerDemon,
	BungieNext,
	All;

	private static final BiMap<Integer, BungieMembershipType> values;
	
	static
	{
		values = HashBiMap.create(BungieMembershipType.values().length);
		
		values.put(0, None);
		values.put(1, TigerXbox);
		values.put(2, TigerPsn);
		values.put(3, TigerSteam);
		values.put(4, TigerBlizzard);
		values.put(5, TigerStadia);
		values.put(6, TigerEgs);
		values.put(10, TigerDemon);
		values.put(254, BungieNext);
		values.put(-1, All);
	}
	
	public static BungieMembershipType fromIndex(int index)
	{
		return values.get(index);
	}
	
	public int getValue()
	{
		return values.inverse().get(this);
	}
}