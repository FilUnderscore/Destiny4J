package com.filunderscore.destiny4j.manifest;

import com.filunderscore.destiny4j.api.entities.manifest.IDestinyDefinitionEntity;
import com.filunderscore.destiny4j.api.entities.manifest.IDestinyManifest;
import com.google.gson.Gson;

public abstract class DestinyEntityManifestParser
{
	protected static final String URL = "https://www.bungie.net";
	protected final Gson gson = new Gson();
	
	protected abstract void updateManifestData(IDestinyManifest manifest);
	
	protected abstract <T extends IDestinyDefinitionEntity> T getDefinitionEntity(Class<T> definitionEntityClass, long hash);
	protected abstract <T extends IDestinyDefinitionEntity> T[] getAllDefinitionEntities(Class<T> definitionEntityClass);
}