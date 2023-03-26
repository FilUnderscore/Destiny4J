package net.bungie.api.destiny.historicalstats;

import java.util.HashMap;
import java.util.Map;

import net.bungie.api.destiny.DestinyGender;
import net.bungie.api.destiny.definitions.DestinyDefinition;

public class DestinyRaceDefinition extends DestinyDefinition
{
	public int raceType;
	public Map<Integer, String> genderedRaceNames;
	public Map<Long, String> genderedRaceNamesByGenderHash;
	
	public DestinyRace getRaceType()
	{
		return DestinyRace.values()[this.raceType];
	}
	
	public Map<DestinyGender, String> getGenderedRaceNames()
	{
		Map<DestinyGender, String> genderedRaceNames = new HashMap<>();
		
		this.genderedRaceNames.forEach((key, value) ->
		{
			genderedRaceNames.put(DestinyGender.values()[key], value);
		});
		
		return genderedRaceNames;
	}
}