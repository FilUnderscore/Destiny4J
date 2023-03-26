package net.bungie.api.destiny.components.profiles;

import java.util.Map;

import net.bungie.api.destiny.artifacts.DestinyArtifactProfileScoped;
import net.bungie.api.destiny.definitions.checklists.DestinyChecklistDefinition;

public class DestinyProfileProgressionComponent
{
	public Map<Long, DestinyChecklistDefinition> checklists;
	public DestinyArtifactProfileScoped seasonalArtifact;
}