package com.filunderscore.destiny4j.impl.rest;

import com.filunderscore.destiny4j.api.rest.IRestKVP;

public final class RestKVP implements IRestKVP
{
	private String key;
	private String value;
	
	public RestKVP(String key, String value)
	{
		this.key = key;
		this.value = value;
	}

	@Override
	public String getKey() 
	{
		return this.key;
	}

	@Override
	public String getValue() 
	{
		return this.value;
	}
}