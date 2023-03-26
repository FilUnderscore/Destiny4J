package net.bungie.api.destiny.historicalstats;

import net.bungie.api.destiny.DestinyGender;
import net.bungie.api.destiny.definitions.DestinyDefinition;

public class DestinyGenderDefinition extends DestinyDefinition
{
	public int genderType;
	
	public DestinyGender getGenderType()
	{
		return DestinyGender.values()[this.genderType];
	}
}