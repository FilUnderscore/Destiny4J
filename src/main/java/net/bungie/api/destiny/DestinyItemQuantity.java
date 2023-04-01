package net.bungie.api.destiny;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.definitions.DestinyInventoryItemDefinition;

public class DestinyItemQuantity 
{
	public long itemHash;
	public long itemInstanceId;
	public int quantity;
	public boolean hasConditionalVisibility;
	
	public DestinyInventoryItemDefinition getItem()
	{
		return DestinyManifest.getInstance().getDefinition(this.itemHash, DestinyInventoryItemDefinition.class);
	}
}