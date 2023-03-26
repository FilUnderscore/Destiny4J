package net.bungie.api.destiny.manifest;

public interface DestinyManifestCallback 
{
	void onManifestRefresh();
	void onManifestRefreshed(DestinyManifest manifest);
}