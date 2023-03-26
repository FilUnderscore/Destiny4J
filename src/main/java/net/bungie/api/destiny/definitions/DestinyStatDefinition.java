package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.DestinyStatAggregationType;
import net.bungie.api.destiny.DestinyStatCategory;

public class DestinyStatDefinition extends DestinyDefinition
{
	public int aggregationType;
	public boolean hasComputedBlock;
	public int statCategory;
	
	public DestinyStatAggregationType getAggregationType()
	{
		return DestinyStatAggregationType.values()[this.aggregationType];
	}
	
	public DestinyStatCategory getStatCategory()
	{
		return DestinyStatCategory.values()[this.statCategory];
	}
}