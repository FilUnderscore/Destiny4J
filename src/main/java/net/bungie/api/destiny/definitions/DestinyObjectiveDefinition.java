package net.bungie.api.destiny.definitions;

public class DestinyObjectiveDefinition extends DestinyDefinition
{
	public int completionValue;
	public int scope;
	public long locationHash;
	public boolean allowNegativeValue;
	public boolean allowValueChangeWhenCompleted;
	public boolean isCountingDownward;
	public int valueStyle;
	public String progressDescription;
	public DestinyObjectivePerkEntryDefinition perks;
	public DestinyObjectiveStatEntryDefinition stats;
	public int minimumVisibilityThreshold;
	public boolean allowOvercompletion;
	public boolean showValueOnComplete;
	public int completedValueStyle;
	public int inProgressValueStyle;
	public String uiLabel;
	public int uiStyle;
	
	// TODO DestinyLocationDefinition
}