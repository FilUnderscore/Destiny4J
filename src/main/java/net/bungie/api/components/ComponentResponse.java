package net.bungie.api.components;

public class ComponentResponse 
{
	public int privacy;
	public boolean disabled;
	
	public ComponentPrivacySetting getPrivacy()
	{
		return ComponentPrivacySetting.values()[this.privacy];
	}
}