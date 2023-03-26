package net.bungie.api.destiny;

public class DestinyProgression
{
	public long progressionHash;
	public int dailyProgress;
	public int dailyLimit;
	public int weeklyProgress;
	public int weeklyLimit;
	public int currentProgress;
	public int level;
	public int levelCap;
	public int stepIndex;
	public int progressToNextLevel;
	public int nextLevelAt;
	public int currentResetCount;
	public DestinyProgressionResetEntry[] seasonResets;
	public int[] rewardItemStates;
}