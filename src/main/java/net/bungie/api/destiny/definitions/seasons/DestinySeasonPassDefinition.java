package net.bungie.api.destiny.definitions.seasons;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.definitions.DestinyDefinition;
import net.bungie.api.destiny.definitions.DestinyProgressionDefinition;
import net.bungie.api.destiny.definitions.common.DestinyDisplayPropertiesDefinition;

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