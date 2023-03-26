package net.bungie.api.destiny.definitions.seasons;

import java.util.Date;

import net.bungie.api.destiny.definitions.DestinyDefinition;
import net.bungie.api.destiny.definitions.DestinyInventoryItemDefinition;
import net.bungie.api.destiny.definitions.DestinyProgressionDefinition;
import net.bungie.api.destiny.definitions.common.DestinyDisplayPropertiesDefinition;
import net.bungie.api.destiny.definitions.presentation.DestinyPresentationNodeDefinition;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinySeasonDefinition extends DestinyDefinition
{
	public String backgroundImagePath;
	public int seasonNumber;
	public Date startDate;
	public Date endDate;
	public long seasonPassHash;
	public long seasonPassProgressionHash;
	public long artifactItemHash;
	public long sealPresentationNodeHash;
	public long seasonalChallengesPresentationNodeHash;
	public DestinySeasonPreviewDefinition preview;
	
	public DestinySeasonPassDefinition getSeasonPass()
	{
		return DestinyManifest.getInstance().getDefinition(this.seasonPassHash, DestinySeasonPassDefinition.class);
	}
	
	public DestinyProgressionDefinition getSeasonPassProgression()
	{
		return DestinyManifest.getInstance().getDefinition(this.seasonPassProgressionHash, DestinyProgressionDefinition.class);
	}
	
	public DestinyInventoryItemDefinition getArtifactItem()
	{
		return DestinyManifest.getInstance().getDefinition(this.artifactItemHash, DestinyInventoryItemDefinition.class);
	}
	
	public DestinyPresentationNodeDefinition getSealPresentationNode()
	{
		return DestinyManifest.getInstance().getDefinition(this.sealPresentationNodeHash, DestinyPresentationNodeDefinition.class);
	}
	
	public DestinyPresentationNodeDefinition getSeasonalChallengesPresentationNode()
	{
		return DestinyManifest.getInstance().getDefinition(this.seasonalChallengesPresentationNodeHash, DestinyPresentationNodeDefinition.class);
	}
}