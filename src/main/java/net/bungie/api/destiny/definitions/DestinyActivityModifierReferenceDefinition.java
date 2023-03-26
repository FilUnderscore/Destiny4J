package net.bungie.api.destiny.definitions;

import net.bungie.api.destiny.definitions.activitymodifiers.DestinyActivityModifierDefinition;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyActivityModifierReferenceDefinition 
{
	public long activityModifierHash;
	
	public DestinyActivityModifierDefinition getActivityModifier()
	{
		return DestinyManifest.getInstance().getDefinition(this.activityModifierHash, DestinyActivityModifierDefinition.class);
	}
}