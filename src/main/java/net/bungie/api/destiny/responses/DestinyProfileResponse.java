package net.bungie.api.destiny.responses;

import net.bungie.api.components.DictionaryComponentResponse;
import net.bungie.api.components.SingleComponentResponse;
import net.bungie.api.destiny.components.profiles.DestinyProfileProgressionComponent;
import net.bungie.api.destiny.components.profiles.DestinyProfileTransitoryComponent;
import net.bungie.api.destiny.entities.characters.DestinyCharacterActivitiesComponent;
import net.bungie.api.destiny.entities.characters.DestinyCharacterProgressionComponent;
import net.bungie.api.destiny.entities.profiles.DestinyProfileComponent;

public class DestinyProfileResponse
{	
	public SingleComponentResponse<DestinyProfileComponent> profile;
	public SingleComponentResponse<DestinyProfileProgressionComponent> profileProgression;
	
	public SingleComponentResponse<DestinyProfileTransitoryComponent> profileTransitoryData;
	public DictionaryComponentResponse<Long, DestinyCharacterProgressionComponent> characterProgressions;
	public DictionaryComponentResponse<Long, DestinyCharacterActivitiesComponent> characterActivities;
}