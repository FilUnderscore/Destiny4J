package net.bungie.api.destiny.historicalstats;

import java.util.Map;

public class DestinyPostGameCarnageReportEntry 
{
	public int standing;
	public DestinyHistoricalStatsValue score;
	public DestinyPlayer player;
	public long characterId;
	public Map<String, DestinyHistoricalStatsValue> values;
	public DestinyPostGameCarnageReportExtendedData extended;
}