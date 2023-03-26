package net.bungie.api.destiny;

import net.bungie.api.destiny.definitions.DestinyInventoryItemDefinition;
import net.bungie.api.destiny.manifest.DestinyManifest;

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