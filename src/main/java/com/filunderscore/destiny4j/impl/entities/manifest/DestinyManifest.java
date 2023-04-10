package com.filunderscore.destiny4j.impl.entities.manifest;

import java.util.Map;

import com.filunderscore.destiny4j.api.entities.manifest.IDestinyManifest;
import com.filunderscore.destiny4j.api.entities.manifest.IGearAssetDataBase;
import com.filunderscore.destiny4j.api.entities.manifest.IImagePyramidEntry;

public final class DestinyManifest implements IDestinyManifest
{
	private String version;
	private String mobileAssetContentPath;
	private GearAssetDataBaseDefinition[] mobileGearAssetDataBases;
	private Map<String, String> mobileWorldContentPaths;
	private Map<String, String> jsonWorldContentPaths;
	private Map<String, Map<String, String>> jsonWorldComponentContentPaths;
	private String mobileClanBannerDatabasePath;
	private Map<String, String> mobileGearCDN;
	private ImagePyramidEntry[] iconImagePyramidInfo;
	
	@Override
	public String getVersion() 
	{
		return this.version;
	}

	@Override
	public String getMobileAssetContentPath() 
	{
		return this.mobileAssetContentPath;
	}

	@Override
	public IGearAssetDataBase[] getMobileGearAssetDataBases() 
	{
		return this.mobileGearAssetDataBases;
	}

	@Override
	public Map<String, String> getMobileWorldContentPaths() 
	{
		return this.mobileWorldContentPaths;
	}

	@Override
	public Map<String, String> getJSONWorldContentPaths() 
	{
		return this.jsonWorldContentPaths;
	}

	@Override
	public Map<String, Map<String, String>> getJSONWorldComponentContentPaths() 
	{
		return this.jsonWorldComponentContentPaths;
	}

	@Override
	public String getMobileClanBannerDatabasePath() 
	{
		return this.mobileClanBannerDatabasePath;
	}

	@Override
	public Map<String, String> getMobileGearCDN() 
	{
		return this.mobileGearCDN;
	}

	@Override
	public IImagePyramidEntry[] getIconImagePyramidInfo() 
	{
		return this.iconImagePyramidInfo;
	}
}