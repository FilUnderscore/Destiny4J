package net.bungie.api.destiny.definitions;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.constants.DestinyEnvironmentLocationMapping;
import net.bungie.api.destiny.definitions.common.DestinyDisplayPropertiesDefinition;

public class DestinyActivityDefinition extends DestinyDefinition
{
	public DestinyDisplayPropertiesDefinition originalDisplayProperties;
	public DestinyDisplayPropertiesDefinition selectionScreenDisplayProperties;
	public String releaseIcon;
	public int releaseTime;
	public int activityLightLevel;
	public long destinationHash;
	public long placeHash;
	public long activityTypeHash;
	public int tier;
	public String pgcrImage;
	public DestinyActivityRewardDefinition[] rewards;
	public DestinyActivityModifierReferenceDefinition[] modifiers;
	public boolean isPlaylist;
	public DestinyActivityChallengeDefinition[] challenges;
	public DestinyActivityUnlockStringDefinition[] optionalUnlockStrings;
	public DestinyActivityPlaylistItemDefinition[] playlistItems;
	public DestinyActivityGraphListEntryDefinition[] activityGraphList;
	public DestinyActivityMatchmakingBlockDefinition matchmaking;
	public DestinyActivityGuidedBlockDefinition guidedGame;
	public long directActivityModeHash;
	public int directActivityModeType;
	public DestinyActivityLoadoutRequirementSet[] loadouts;
	public long[] activityModeHashes;
	public int[] activityModeTypes;
	public boolean isPvP;
	public DestinyActivityInsertionPointDefinition[] insertionPoints;
	public DestinyEnvironmentLocationMapping[] activityLocationMapping;	
	
	public DestinyActivityTypeDefinition getActivityType()
	{
		return DestinyManifest.getInstance().getDefinition(this.activityTypeHash, DestinyActivityTypeDefinition.class);
	}
}