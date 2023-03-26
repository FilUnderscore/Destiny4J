package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.FlagEnumerable;

public class DestinyTalentNodeStepGuardianAttributes extends FlagEnumerable
{
	public static final int None = 0;
	public static final int Stats = 1;
	public static final int Shields = 2;
	public static final int Health = 4;
	public static final int Revive = 8;
	public static final int AimUnderFire = 16;
	public static final int Radar = 32;
	public static final int Invisibility = 64;
	public static final int Reputations = 128;
	public static final int All = 255;
	
	public DestinyTalentNodeStepGuardianAttributes(int flag) 
	{
		super(flag);
	}
}