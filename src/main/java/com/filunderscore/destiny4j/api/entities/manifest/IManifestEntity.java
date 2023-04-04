package com.filunderscore.destiny4j.api.entities.manifest;

public interface IManifestEntity 
{
	long getHash();
	int getIndex();
	boolean isRedacted();
	
	String getName();
	String getDescription();
	String getIconURL();
	
	String[] getIconSequenceFrames();
	
	String getHighResIcon();
}