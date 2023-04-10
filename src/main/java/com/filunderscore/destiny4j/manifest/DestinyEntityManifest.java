package com.filunderscore.destiny4j.manifest;

import java.util.Calendar;
import java.util.TimeZone;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import com.filunderscore.destiny4j.api.IDestiny2API;
import com.filunderscore.destiny4j.api.entities.manifest.IDestinyDefinitionEntity;
import com.filunderscore.destiny4j.api.entities.manifest.IDestinyManifest;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public final class DestinyEntityManifest 
{
	static final BiMap<String, Class<? extends IDestinyDefinitionEntity>> DEFINITION_CLASSES;
	
	static
	{
		DEFINITION_CLASSES = populateDefinitionClasses();
	}
	
	@SuppressWarnings("unchecked")
	private static BiMap<String, Class<? extends IDestinyDefinitionEntity>> populateDefinitionClasses()
	{
		BiMap<String, Class<? extends IDestinyDefinitionEntity>> definitionClasses = HashBiMap.create();
		
		Reflections reflections = new Reflections("com.filunderscore.destiny4j.api.entities");
		
		for(Class<?> clazz : reflections.get(Scanners.SubTypes.of(IDestinyDefinitionEntity.class).asClass()))
		{
			DEFINITION_CLASSES.put(clazz.getSimpleName(), (Class<? extends IDestinyDefinitionEntity>)clazz);
		}
		
		return definitionClasses;
	}
	
	private final IDestiny2API api;
	private final DestinyEntityManifestParser parser;

	private String currentManifestVersion;
	private long nextManifestRefresh;
	
	public DestinyEntityManifest(IDestiny2API api, DestinyEntityManifestParser parser)
	{
		this.api = api;
		this.parser = parser;
	}
	
	private boolean isUpdateNeeded()
	{
		return System.currentTimeMillis() >= nextManifestRefresh;
	}
	
	private void update()
	{
		if(!isUpdateNeeded())
			return;
		
		IDestinyManifest manifest = this.api.getDestinyManifest().execute();
		boolean isNewVersion = !manifest.getVersion().equals(this.currentManifestVersion);
		
		if(isNewVersion)
		{
			this.parser.updateManifestData(manifest);
		}
		
		this.setNextUpdateTime();
	}
	
	private void setNextUpdateTime()
	{
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("PST"));
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 10);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		this.nextManifestRefresh = calendar.getTimeInMillis();
	}
	
	public <T extends IDestinyDefinitionEntity> T getDefinitionEntity(Class<T> definitionEntityClass, long hash)
	{
		this.update();
		return this.parser.getDefinitionEntity(definitionEntityClass, hash);
	}
	
	public <T extends IDestinyDefinitionEntity> T[] getAllDefinitionEntities(Class<T> definitionEntityClass)
	{
		this.update();
		return this.parser.getAllDefinitionEntities(definitionEntityClass);
	}
}