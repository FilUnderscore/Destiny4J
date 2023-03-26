package net.bungie.api;

public enum BungieMembershipType
{
	None(0),
	TigerXbox(1),
	TigerPsn(2),
	TigerSteam(3),
	TigerBlizzard(4),
	TigerStadia(5),
	TigerEgs(6),
	TigerDemon(10),
	BungieNext(254),
	All(-1);
	
	private int id;
	
	private BungieMembershipType(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public static BungieMembershipType fromId(int id)
	{
		for(BungieMembershipType value : values())
		{
			if(value.id == id)
				return value;
		}
		
		return BungieMembershipType.None;
	}
}