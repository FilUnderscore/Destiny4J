package net.bungie.api.destiny.definitions;

import java.util.Map;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.definitions.common.DestinyDisplayPropertiesDefinition;

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