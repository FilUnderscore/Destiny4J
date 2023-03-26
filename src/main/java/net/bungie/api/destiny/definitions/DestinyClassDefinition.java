package net.bungie.api.destiny.definitions;

import java.util.HashMap;
import java.util.Map;

import net.bungie.api.destiny.DestinyClass;
import net.bungie.api.destiny.DestinyGender;
import net.bungie.api.destiny.manifest.DestinyManifest;

public class DestinyClassDefinition extends DestinyDefinition
{
	public int classType;
	public Map<String, String> genderedClassNames;
	public Map<Long, String> genderedClassNamesByGenderHash;
	public long mentorVendorHash;
	
	public DestinyClass getClassType()
	{
		return DestinyClass.values()[this.classType];
	}
	
	public Map<DestinyGender, String> getGenderedClassNames()
	{
		Map<DestinyGender, String> genderedClassNames = new HashMap<>();
		
		this.genderedClassNames.forEach((key, value) ->
		{
			genderedClassNames.put(DestinyGender.valueOf(key), value);
		});
		
		return genderedClassNames;
	}
	
	public DestinyVendorDefinition getMentorVendor()
	{
		return DestinyManifest.getInstance().getDefinition(this.mentorVendorHash, DestinyVendorDefinition.class);
	}
}