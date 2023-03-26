package net.bungie.api.destiny.milestones;

import java.util.Map;

import net.bungie.api.destiny.definitions.DestinyActivityDefinition;
import net.bungie.api.destiny.definitions.DestinyObjectiveDefinition;
import net.bungie.api.destiny.definitions.activitymodifiers.DestinyActivityModifierDefinition;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyPublicMilestoneChallengeActivity 
{
	public long activityHash;
	public long[] challengeObjectiveHashes;
	public long[] modifierHashes;
	public int loadoutRequirementIndex;
	public long[] phaseHashes;
	public Map<Long, Boolean> booleanActivityOptions;
	
	public DestinyActivityDefinition getActivity()
	{
		return DestinyManifest.getInstance().getDefinition(this.activityHash, DestinyActivityDefinition.class);
	}
	
	public DestinyObjectiveDefinition[] getChallengeObjectives()
	{
		return DestinyManifest.getInstance().getDefinitions(this.challengeObjectiveHashes, DestinyObjectiveDefinition.class);
	}
	
	public DestinyActivityModifierDefinition[] getModifiers()
	{
		return DestinyManifest.getInstance().getDefinitions(this.modifierHashes, DestinyActivityModifierDefinition.class);
	}
}