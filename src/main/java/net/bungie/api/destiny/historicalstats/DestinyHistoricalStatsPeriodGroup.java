package net.bungie.api.destiny.historicalstats;

import java.util.Date;
import java.util.Map;

public class DestinyHistoricalStatsPeriodGroup 
{
	public Date period;
	public DestinyHistoricalStatsActivity activityDetails;
	public Map<String, DestinyHistoricalStatsValue> values;
}