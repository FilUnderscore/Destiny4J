package net.bungie.api.destiny.entities.characters;

import java.util.Date;

import net.bungie.api.destiny.DestinyActivity;
import net.bungie.api.destiny.definitions.DestinyActivityDefinition;
import net.bungie.api.destiny.definitions.DestinyActivityModeDefinition;
import net.bungie.api.destiny.historicalstats.definitions.DestinyActivityModeType;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyCharacterActivitiesComponent 
{
	public Date dateActivityStarted;
	public DestinyActivity[] availableActivities;
	public Long currentActivityHash;
	public Long currentActivityModeHash;
	public Integer currentActivityModeType;
	public Long[] currentActivityModeHashes;
	public Integer[] currentActivityModeTypes;
	public Long currentPlaylistActivityHash;
	public Long lastCompletedStoryHash;
	
	public DestinyActivityDefinition getCurrentActivity()
	{
		return DestinyManifest.getInstance().getDefinition(this.currentActivityHash, DestinyActivityDefinition.class);
	}
	
	public DestinyActivityModeDefinition getCurrentActivityMode()
	{
		return DestinyManifest.getInstance().getDefinition(this.currentActivityModeHash, DestinyActivityModeDefinition.class);
	}
	
	public DestinyActivityModeType getCurrentActivityModeType()
	{
		return DestinyActivityModeType.values()[this.currentActivityModeType];
	}
	
	public DestinyActivityModeDefinition[] getCurrentActivityModes()
	{
		return DestinyManifest.getInstance().getDefinitions(this.currentActivityModeHashes, DestinyActivityModeDefinition.class);
	}
	
	public DestinyActivityModeType[] getCurrentActivityModeTypes()
	{
		DestinyActivityModeType[] currentActivityModeTypes = new DestinyActivityModeType[this.currentActivityModeTypes.length];
		
		for(int i = 0; i < currentActivityModeTypes.length; i++)
		{
			currentActivityModeTypes[i] = DestinyActivityModeType.values()[this.currentActivityModeTypes[i]];
		}
		
		return currentActivityModeTypes;
	}
	
	public DestinyActivityDefinition getCurrentPlaylistActivity()
	{
		return DestinyManifest.getInstance().getDefinition(this.currentPlaylistActivityHash, DestinyActivityDefinition.class);
	}
	
	public DestinyActivityDefinition getLastCompletedStory()
	{
		return DestinyManifest.getInstance().getDefinition(this.lastCompletedStoryHash, DestinyActivityDefinition.class);
	}
}