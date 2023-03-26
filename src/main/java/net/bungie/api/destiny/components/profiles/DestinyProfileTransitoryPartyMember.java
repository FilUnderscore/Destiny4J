package net.bungie.api.destiny.components.profiles;

import net.bungie.api.destiny.DestinyPartyMemberStates;
import net.bungie.api.destiny.definitions.DestinyInventoryItemDefinition;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyProfileTransitoryPartyMember 
{
	public long membershipId;
	public long emblemHash;
	public String displayName;
	public int status;
	
	public DestinyInventoryItemDefinition getEmblem()
	{
		return DestinyManifest.getInstance().getDefinition(emblemHash, DestinyInventoryItemDefinition.class);
	}
	
	public DestinyPartyMemberStates getStatus()
	{
		return new DestinyPartyMemberStates(status);
	}
}