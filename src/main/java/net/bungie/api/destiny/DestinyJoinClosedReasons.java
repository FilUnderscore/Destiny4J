package net.bungie.api.destiny;

public class DestinyJoinClosedReasons extends FlagEnumerable
{
	public static final int None = 0;
	public static final int InMatchmaking = 1;
	public static final int Loading = 2;
	public static final int SoloMode = 4;
	public static final int InternalReasons = 8;
	public static final int DisallowedByGameState = 16;
	public static final int Offline = 32768;

	public DestinyJoinClosedReasons(int flag) 
	{
		super(flag);
	}
}