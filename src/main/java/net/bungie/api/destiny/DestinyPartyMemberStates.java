package net.bungie.api.destiny;

public final class DestinyPartyMemberStates extends FlagEnumerable
{
	public static final int None = 0;
	public static final int FireteamMember = 1;
	public static final int PosseMember = 2;
	public static final int GroupMember = 4;
	public static final int PartyLeader = 8;
	
	public DestinyPartyMemberStates(int flag) 
	{
		super(flag);
	}
}