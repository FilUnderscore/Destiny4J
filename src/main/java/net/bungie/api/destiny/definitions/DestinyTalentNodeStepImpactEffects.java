package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.FlagEnumerable;

public class DestinyTalentNodeStepImpactEffects extends FlagEnumerable
{
	public static final int None = 0;
	public static final int ArmorPiercing = 1;
	public static final int Ricochet = 2;
	public static final int Flinch = 4;
	public static final int CollateralDamage = 8;
	public static final int Disorient = 16;
	public static final int HighlightTarget = 32;
	public static final int All = 63;
	
	public DestinyTalentNodeStepImpactEffects(int flag)
	{
		super(flag);
	}
}