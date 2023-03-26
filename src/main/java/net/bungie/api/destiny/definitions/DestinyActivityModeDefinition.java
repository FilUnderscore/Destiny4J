package net.bungie.api.destiny.definitions;

import java.util.Map;

import net.bungie.api.destiny.DestinyActivityModeCategory;

public class DestinyActivityModeDefinition extends DestinyDefinition
{
	public String pgcrImage;
	public int modeType;
	public int activityModeCategory;
	public boolean isTeamBased;
	public boolean isAggregateMode;
	public long[] parentHashes;
	public String friendlyName;
	public Map<Long, Integer> activityModeMappings;
	public boolean display;
	public int order;
	
	public DestinyActivityModeCategory getActivityModeCategory()
	{
		return DestinyActivityModeCategory.values()[this.activityModeCategory];
	}
}