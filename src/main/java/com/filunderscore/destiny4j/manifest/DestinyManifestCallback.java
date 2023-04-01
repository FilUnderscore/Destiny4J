package com.filunderscore.destiny4j.manifest;

public interface DestinyManifestCallback 
{
	void onManifestRefresh();
	void onManifestRefreshed(DestinyManifest manifest);
}