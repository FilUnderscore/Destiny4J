package net.bungie.api.destiny.definitions;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.DestinyItemQuantity;

public class DestinyActivityChallengeDefinition 
{
	public long objectiveHash;
	public DestinyItemQuantity[] dummyRewards;
	
	public DestinyObjectiveDefinition getObjective()
	{
		return DestinyManifest.getInstance().getDefinition(this.objectiveHash, DestinyObjectiveDefinition.class);
	}
}