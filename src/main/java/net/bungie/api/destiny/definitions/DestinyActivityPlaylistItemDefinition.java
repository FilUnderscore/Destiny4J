package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.historicalstats.definitions.DestinyActivityModeType;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyActivityPlaylistItemDefinition 
{
	public long activityHash;
	public long directActivityModeHash;
	public int directActivityModeType;
	public long[] activityModeHashes;
	public int[] activityModeTypes;
	
	public DestinyActivityModeType getDirectActivityModeType()
	{
		return DestinyActivityModeType.values()[this.directActivityModeType];
	}
	
	public DestinyActivityModeDefinition[] getActivityModes()
	{
		return DestinyManifest.getInstance().getDefinitions(this.activityModeHashes, DestinyActivityModeDefinition.class);
	}
}