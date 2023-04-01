package net.bungie.api.destiny;

import java.util.Map;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.challenges.DestinyChallengeStatus;
import net.bungie.api.destiny.definitions.DestinyActivityDefinition;
import net.bungie.api.destiny.definitions.activitymodifiers.DestinyActivityModifierDefinition;

public class DestinyActivity 
{
	public long activityHash;
	public boolean isNew;
	public boolean canLead;
	public boolean canJoin;
	public boolean isCompleted;
	public boolean isVisible;
	public int displayLevel;
	public int recommendedLight;
	public int difficultyTier;
	public DestinyChallengeStatus[] challenges;
	public long[] modifierHashes;
	public Map<Long, Boolean> booleanActivityOptions;
	public int loadoutRequirementIndex;
	
	public DestinyActivityDefinition getActivity()
	{
		return DestinyManifest.getInstance().getDefinition(this.activityHash, DestinyActivityDefinition.class);
	}
	
	public DestinyActivityDifficultyTier getDifficultyTier()
	{
		return DestinyActivityDifficultyTier.values()[this.difficultyTier];
	}
	
	public DestinyActivityModifierDefinition[] getModifiers()
	{
		return DestinyManifest.getInstance().getDefinitions(this.modifierHashes, DestinyActivityModifierDefinition.class);
	}
}