package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.FlagEnumerable;

public class DestinyTalentNodeStepWeaponPerformances extends FlagEnumerable
{
	public static final int None = 0;
	public static final int RateOfFire = 1;
	public static final int Damage = 2;
	public static final int Accuracy = 4;
	public static final int Range = 8;
	public static final int Zoom = 16;
	public static final int Recoil = 32;
	public static final int Ready = 64;
	public static final int Reload = 128;
	public static final int HairTrigger = 256;
	public static final int AmmoAndMagazine = 512;
	public static final int TrackingAndDetonation = 1024;
	public static final int ShotgunSpread = 2048;
	public static final int ChargeTime = 4096;
	public static final int All = 8191;
	
	public DestinyTalentNodeStepWeaponPerformances(int flag) 
	{
		super(flag);
	}
}