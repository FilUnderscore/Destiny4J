package net.bungie.api.destiny;

public abstract class FlagEnumerable 
{
	private final int value;
	
	public FlagEnumerable(int flag)
	{
		value = flag;
	}
	
	public final boolean isFlagSet(int flag)
	{
		return (value & flag) == flag;
	}
}