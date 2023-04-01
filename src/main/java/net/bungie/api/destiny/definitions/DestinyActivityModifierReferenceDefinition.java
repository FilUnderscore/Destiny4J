package net.bungie.api.destiny.definitions;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.definitions.activitymodifiers.DestinyActivityModifierDefinition;

public class DestinyActivityModifierReferenceDefinition 
{
	public long activityModifierHash;
	
	public DestinyActivityModifierDefinition getActivityModifier()
	{
		return DestinyManifest.getInstance().getDefinition(this.activityModifierHash, DestinyActivityModifierDefinition.class);
	}
}