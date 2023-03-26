package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyItemInvestmentStatDefinition 
{
	public long statTypeHash;
	public int value;
	public boolean isConditionallyActive;
	
	public DestinyStatDefinition getStatType()
	{
		return DestinyManifest.getInstance().getDefinition(this.statTypeHash, DestinyStatDefinition.class);
	}
}