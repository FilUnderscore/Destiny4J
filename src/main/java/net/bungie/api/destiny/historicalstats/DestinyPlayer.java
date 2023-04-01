package net.bungie.api.destiny.historicalstats;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.definitions.DestinyClassDefinition;
import net.bungie.api.destiny.definitions.DestinyInventoryItemDefinition;
import net.bungie.api.user.UserInfoCard;

public class DestinyPlayer 
{
	public UserInfoCard destinyUserInfo;
	public String characterClass;
	public long classHash;
	public long raceHash;
	public long genderHash;
	public int characterLevel;
	public int lightLevel;
	public UserInfoCard bungieNetUserInfo;
	public String clanName;
	public String clanTag;
	public long emblemHash;
	
	public DestinyClassDefinition getPlayerClass()
	{
		return DestinyManifest.getInstance().getDefinition(this.classHash, DestinyClassDefinition.class);
	}
	
	public DestinyRaceDefinition getRace()
	{
		return DestinyManifest.getInstance().getDefinition(this.raceHash, DestinyRaceDefinition.class);
	}
	
	public DestinyGenderDefinition getGender()
	{
		return DestinyManifest.getInstance().getDefinition(this.genderHash, DestinyGenderDefinition.class);
	}
	
	public DestinyInventoryItemDefinition getEmblem()
	{
		return DestinyManifest.getInstance().getDefinition(this.emblemHash, DestinyInventoryItemDefinition.class);
	}
}