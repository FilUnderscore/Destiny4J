package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.FlagEnumerable;

public class DestinyTalentNodeStepDamageTypes extends FlagEnumerable
{
	public static final int None = 0;
	public static final int Kinetic = 1;
	public static final int Arc = 2;
	public static final int Solar = 4;
	public static final int Void = 8;
	public static final int All = 15;
	
	public DestinyTalentNodeStepDamageTypes(int flag) 
	{
		super(flag);
	}
}