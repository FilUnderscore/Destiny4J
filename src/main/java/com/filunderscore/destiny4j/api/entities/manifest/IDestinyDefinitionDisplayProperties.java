package com.filunderscore.destiny4j.api.entities.manifest;

public interface IDestinyDefinitionDisplayProperties 
{
	String getName();
	String getDescription();
	String getIconURL();
	
	String[] getIconSequenceFrames();
	
	String getHighResIcon();
	
	boolean hasIcon();
}