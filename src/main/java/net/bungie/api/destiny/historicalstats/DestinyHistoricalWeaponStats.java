package net.bungie.api.destiny.historicalstats;

import java.util.Map;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.definitions.DestinyInventoryItemDefinition;

public class DestinyHistoricalWeaponStats 
{
	public long referenceId;
	public Map<String, DestinyHistoricalStatsValue> values;
	
	public DestinyInventoryItemDefinition getWeapon()
	{
		return DestinyManifest.getInstance().getDefinition(this.referenceId, DestinyInventoryItemDefinition.class);
	}
}