package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.FlagEnumerable;

public class DestinyTalentNodeStepLightAbilities extends FlagEnumerable
{
	public static final int None = 0;
	public static final int Grenades = 1;
	public static final int Melee = 2;
	public static final int MovementModes = 4;
	public static final int Orbs = 8;
	public static final int SuperEnergy = 16;
	public static final int SuperMods = 32;
	public static final int All = 63;
	
	public DestinyTalentNodeStepLightAbilities(int flag) 
	{
		super(flag);
	}
}