package net.bungie.api.destiny.historicalstats;

import java.util.Date;

public class DestinyPostGameCarnageReportData 
{
	public Date period;
	public int startingPhaseIndex;
	public boolean activityWasStartedFromBeginning;
	public DestinyHistoricalStatsActivity activityDetails;
	public DestinyPostGameCarnageReportEntry[] entries;
	public DestinyPostGameCarnageReportTeamEntry[] teams;
}