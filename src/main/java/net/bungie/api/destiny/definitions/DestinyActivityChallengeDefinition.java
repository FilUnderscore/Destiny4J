package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.DestinyItemQuantity;

import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyActivityChallengeDefinition 
{
	public long objectiveHash;
	public DestinyItemQuantity[] dummyRewards;
	
	public DestinyObjectiveDefinition getObjective()
	{
		return DestinyManifest.getInstance().getDefinition(this.objectiveHash, DestinyObjectiveDefinition.class);
	}
}