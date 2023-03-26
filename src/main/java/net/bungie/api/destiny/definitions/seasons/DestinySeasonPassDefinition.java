package net.bungie.api.destiny.definitions.seasons;

import net.bungie.api.destiny.definitions.DestinyDefinition;
import net.bungie.api.destiny.definitions.DestinyProgressionDefinition;
import net.bungie.api.destiny.definitions.common.DestinyDisplayPropertiesDefinition;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinySeasonPassDefinition extends DestinyDefinition
{
	public long rewardProgressionHash;
	public long prestigeProgressionHash;
	
	public DestinyProgressionDefinition getRewardProgression()
	{
		return DestinyManifest.getInstance().getDefinition(this.rewardProgressionHash, DestinyProgressionDefinition.class);
	}
	
	public DestinyProgressionDefinition getPrestigeProgression()
	{
		return DestinyManifest.getInstance().getDefinition(this.prestigeProgressionHash, DestinyProgressionDefinition.class);
	}
}