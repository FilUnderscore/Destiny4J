package net.bungie.api.destiny.activities;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.DestinyItemQuantity;
import net.bungie.api.destiny.definitions.DestinyObjectiveDefinition;
import net.bungie.api.destiny.definitions.activitymodifiers.DestinyActivityModifierDefinition;

public class DestinyPublicActivityStatus 
{
	public long[] challengeObjectiveHashes;
	public long[] modifierHashes;
	public DestinyItemQuantity[] rewardTooltipItems;
	
	public DestinyObjectiveDefinition[] getChallengeObjectives()
	{
		return DestinyManifest.getInstance().getDefinitions(this.challengeObjectiveHashes, DestinyObjectiveDefinition.class);
	}
	
	public DestinyActivityModifierDefinition[] getModifiers()
	{
		return DestinyManifest.getInstance().getDefinitions(this.modifierHashes, DestinyActivityModifierDefinition.class);
	}
}