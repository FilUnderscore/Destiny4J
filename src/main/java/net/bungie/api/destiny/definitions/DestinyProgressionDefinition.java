package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.manifest.DestinyManifest;
import net.bungie.api.destiny.misc.DestinyColor;

public class DestinyProgressionDefinition extends DestinyDefinition
{
	public int scope;
	public boolean repeatLastStep;
	public String source;
	public DestinyProgressionStepDefinition[] steps;
	public boolean visible;
	public long factionHash;
	public DestinyColor color;
	public String rankIcon;
	public DestinyProgressionRewardItemQuantity[] rewardItems;
	
	public DestinyFactionDefinition getFaction()
	{
		return DestinyManifest.getInstance().getDefinition(this.factionHash, DestinyFactionDefinition.class);
	}
}