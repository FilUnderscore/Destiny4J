package com.filunderscore.destiny4j.impl.entities.manifest;

import com.filunderscore.destiny4j.api.entities.manifest.IGearAssetDataBase;

public final class GearAssetDataBaseDefinition implements IGearAssetDataBase
{
	private int version;
	private String path;
	
	@Override
	public int getVersion() 
	{
		return this.version;
	}

	@Override
	public String getPath() 
	{
		return this.path;
	}
}