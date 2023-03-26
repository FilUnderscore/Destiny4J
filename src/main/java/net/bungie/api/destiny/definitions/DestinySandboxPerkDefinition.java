package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinySandboxPerkDefinition extends DestinyDefinition
{
	public String perkIdentifier;
	public boolean isDisplayable;
	public int damageType;
	public long damageTypeHash;
	public DestinyTalentNodeStepGroups[] perkGroups;
	
	public DestinyDamageTypeDefinition getDamageType()
	{
		return DestinyManifest.getInstance().getDefinition(this.damageTypeHash, DestinyDamageTypeDefinition.class);
	}
}