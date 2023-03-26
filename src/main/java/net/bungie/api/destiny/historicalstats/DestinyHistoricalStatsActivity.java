package net.bungie.api.destiny.historicalstats;

import net.bungie.api.BungieMembershipType;
import net.bungie.api.destiny.definitions.DestinyActivityDefinition;
import net.bungie.api.destiny.historicalstats.definitions.DestinyActivityModeType;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyHistoricalStatsActivity 
{
	public long referenceId;
	public long directorActivityHash;
	public long instanceId;
	public int mode;
	public int[] modes;
	public boolean isPrivate;
	public int membershipType;
	
	public DestinyActivityDefinition getActivity()
	{
		return DestinyManifest.getInstance().getDefinition(this.referenceId, DestinyActivityDefinition.class);
	}
	
	public DestinyActivityDefinition getDirectorActivity()
	{
		return DestinyManifest.getInstance().getDefinition(this.directorActivityHash, DestinyActivityDefinition.class);
	}
	
	public DestinyActivityModeType getMode()
	{
		return DestinyActivityModeType.values()[this.mode];
	}
	
	public DestinyActivityModeType[] getModes()
	{
		DestinyActivityModeType[] modes = new DestinyActivityModeType[this.modes.length];
		
		for(int i = 0; i < modes.length; i++)
		{
			modes[i] = DestinyActivityModeType.values()[this.modes[i]];
		}
		
		return modes;
	}
	
	public BungieMembershipType getMembershipType()
	{
		return BungieMembershipType.fromId(this.membershipType);
	}
}