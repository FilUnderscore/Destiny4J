package net.bungie.api.destiny.components.profiles;

import net.bungie.api.destiny.DestinyGamePrivacySetting;
import net.bungie.api.destiny.DestinyJoinClosedReasons;

public class DestinyProfileTransitoryJoinability 
{
	public int openSlots;
	public int privacySetting;
	public int closedReasons;
	
	public DestinyGamePrivacySetting getPrivacySetting()
	{
		return DestinyGamePrivacySetting.values()[this.privacySetting];
	}
	
	public DestinyJoinClosedReasons getClosedReasons()
	{
		return new DestinyJoinClosedReasons(this.closedReasons);
	}
}