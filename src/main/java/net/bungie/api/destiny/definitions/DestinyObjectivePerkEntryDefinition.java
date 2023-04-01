package net.bungie.api.destiny.definitions;

import com.filunderscore.destiny4j.manifest.DestinyManifest;

import net.bungie.api.destiny.DestinyObjectiveGrantStyle;

public class DestinyObjectivePerkEntryDefinition 
{
	public long perkHash;
	public int style;
	
	public DestinySandboxPerkDefinition getPerk()
	{
		return DestinyManifest.getInstance().getDefinition(this.perkHash, DestinySandboxPerkDefinition.class);
	}
	
	public DestinyObjectiveGrantStyle getStyle()
	{
		return DestinyObjectiveGrantStyle.values()[this.style];
	}
}