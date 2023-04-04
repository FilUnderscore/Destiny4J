package com.filunderscore.destiny4j.api.entities.manifest;

import java.util.Map;

public interface IDestinyManifest 
{
	String getVersion();
	
	String getMobileAssetContentPath();
	IGearAssetDataBase[] getMobileGearAssetDataBases();
	Map<String, String> getMobileWorldContentPaths();
	
	Map<String, String> getJSONWorldContentPaths();
	Map<String, Map<String, String>> getJSONWorldComponentContentPaths();
	
	String getMobileClanBannerDatabasePath();
	Map<String, String> getMobileGearCDN();
	
	IImagePyramidEntry[] getIconImagePyramidInfo();
}