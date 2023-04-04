package com.filunderscore.destiny4j.api.exceptions;

import java.util.HashMap;
import java.util.Map;

public enum PlatformErrorCodes 
{
	None,
	Success,
	TransportException,
	UnhandledException,
	NotImplemented,
	SystemDisabled;
	
	private static final Map<Integer, PlatformErrorCodes> values;
	
	static
	{
		values = new HashMap<>();
		
		values.put(0, None);
		values.put(1, Success);
		values.put(2, TransportException);
		values.put(3, UnhandledException);
		values.put(4, NotImplemented);
		values.put(5, SystemDisabled);
	}
	
	public static PlatformErrorCodes fromIndex(int index)
	{
		if(!values.containsKey(index))
			return NotImplemented;
		
		return values.get(index);
	}
}