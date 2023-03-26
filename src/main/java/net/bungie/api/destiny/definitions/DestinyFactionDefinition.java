package net.bungie.api.destiny.definitions;

import java.util.Map;

import net.bungie.api.destiny.definitions.common.DestinyDisplayPropertiesDefinition;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyFactionDefinition extends DestinyDefinition
{
	public long progressionHash;
	public Map<Long, Long> tokenValues;
	public long rewardItemHash;
	public DestinyFactionVendorDefinition[] vendors;
	
	public DestinyProgressionDefinition getProgression()
	{
		return DestinyManifest.getInstance().getDefinition(this.progressionHash, DestinyProgressionDefinition.class);
	}
	
	public DestinyInventoryItemDefinition getRewardItem()
	{
		return DestinyManifest.getInstance().getDefinition(this.rewardItemHash, DestinyInventoryItemDefinition.class);
	}
}