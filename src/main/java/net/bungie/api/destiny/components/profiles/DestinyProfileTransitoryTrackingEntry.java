package net.bungie.api.destiny.components.profiles;

import java.util.Date;

import net.bungie.api.destiny.definitions.DestinyInventoryItemDefinition;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyProfileTransitoryTrackingEntry 
{
	public long locationHash;
	public long itemHash;
	public long objectiveHash;
	public long activityHash;
	public long questlineItemHash;
	public Date trackedDate;
	
	// TODO
	public DestinyInventoryItemDefinition getItem()
	{
		return DestinyManifest.getInstance().getDefinition(this.itemHash, DestinyInventoryItemDefinition.class);
	}
	
	public DestinyInventoryItemDefinition getQuestlineItem()
	{
		return DestinyManifest.getInstance().getDefinition(this.questlineItemHash, DestinyInventoryItemDefinition.class);
	}
}