package net.bungie.api.destiny.definitions;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

public class DestinyProgressionRewardItemQuantity
{
	public int rewardedAtProgessionLevel;
	public int acquisitionBehavior;
	public String uiDisplayStyle;
	public String[] claimUnlockDisplayStrings;
	public long itemHash;
	public Long itemInstanceId;
	public int quantity;
	public boolean hasConditionalVisibility;
	
	public DestinyInventoryItemDefinition getItem()
	{
		return DestinyManifest.getInstance().getDefinition(this.itemHash, DestinyInventoryItemDefinition.class);
	}
}