package com.filunderscore.destiny4j.impl.entities.manifest;

import com.filunderscore.destiny4j.api.entities.manifest.IImagePyramidEntry;

public final class ImagePyramidEntry implements IImagePyramidEntry
{
	private String name;
	private float factor;
	
	@Override
	public String getName() 
	{
		return this.name;
	}

	@Override
	public float getFactor() 
	{
		return this.factor;
	}
}