package net.bungie.api.common.models;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.definitions.DestinyVendorDefinition;
import net.bungie.api.destiny.definitions.seasons.DestinySeasonDefinition;

public class Destiny2CoreSettings 
{
	public long collectionRootNode;
	public long badgesRootNode;
	public long recordsRootNode;
	public long medalsRootNode;
	public long metricsRootNode;
	public long activeTriumphsRootNodeHash;
	public long activeSealsRootNodeHash;
	public long legacyTriumphsRootNodeHash;
	public long legacySealsRootNodeHash;
	public long medalsRootNodeHash;
	public long exoticCatalystsRootNodeHash;
	public long loreRootNodeHash;
	public long craftingRootNodeHash;
	public long[] currentRankProgessionHashes;
	public long[] insertPlugFreeProtectedPlugItemHashes;
	public long[] insertPlugFreeBlockedSocketTypeHashes;
	public String undiscoveredCollectibleImage;
	public String ammoTypeHeavyIcon;
	public String ammoTypeSpecialIcon;
	public String ammoTypePrimaryIcon;
	public long currentSeasonalArtifactHash;
	public long currentSeasonHash;
	public long seasonalChallengesPresentationNodeHash;
	public long[] futureSeasonHashes;
	public long[] pastSeasonHashes;
	
	public DestinyVendorDefinition getCurrentSeasonalArtifact()
	{
		return DestinyManifest.getInstance().getDefinition(this.currentSeasonalArtifactHash, DestinyVendorDefinition.class);
	}
	
	public DestinySeasonDefinition getCurrentSeason()
	{
		return DestinyManifest.getInstance().getDefinition(this.currentSeasonHash, DestinySeasonDefinition.class);
	}
	
	public DestinySeasonDefinition[] getFutureSeasons()
	{
		return DestinyManifest.getInstance().getDefinitions(this.futureSeasonHashes, DestinySeasonDefinition.class);
	}
	
	public DestinySeasonDefinition[] getPastSeasons()
	{
		return DestinyManifest.getInstance().getDefinitions(this.pastSeasonHashes, DestinySeasonDefinition.class);
	}
}