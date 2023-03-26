package net.bungie.api.destiny.historicalstats;

import java.util.Map;

import net.bungie.api.destiny.definitions.DestinyInventoryItemDefinition;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyHistoricalWeaponStats 
{
	public long referenceId;
	public Map<String, DestinyHistoricalStatsValue> values;
	
	public DestinyInventoryItemDefinition getWeapon()
	{
		return DestinyManifest.getInstance().getDefinition(this.referenceId, DestinyInventoryItemDefinition.class);
	}
}