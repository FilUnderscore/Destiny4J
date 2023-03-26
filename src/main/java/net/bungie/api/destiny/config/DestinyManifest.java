package net.bungie.api.destiny.config;

import java.util.Map;

public class DestinyManifest
{
	public String version;
	public String mobileAssetContentPath;
	public GearAssetDataBaseDefinition[] mobileGearAssetDataBases;
	public Map<String, String> mobileWorldContentPaths;
	public Map<String, String> jsonWorldContentPaths;
	public Map<String, Map<String, String>> jsonWorldComponentContentPaths;
	public String mobileClanBannerDatabasePath;
	public Map<String, String> mobileGearCDN;
	public ImagePyramidEntry[] iconImagePyramidInfo;
}