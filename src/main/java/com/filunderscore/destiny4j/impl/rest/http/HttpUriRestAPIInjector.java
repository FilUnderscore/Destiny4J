package com.filunderscore.destiny4j.impl.rest.http;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.filunderscore.destiny4j.api.annotations.InjectAPI;
import com.filunderscore.destiny4j.api.rest.IRestAPI;
import com.filunderscore.destiny4j.api.rest.IRestEntity;

public final class HttpUriRestAPIInjector<Response>
{
	private final HttpUriRestSession session;
	
	public HttpUriRestAPIInjector(HttpUriRestSession session)
	{
		this.session = session;
	}
	
	public boolean tryInject(Response response)
	{
		try 
		{
			Map<Field, List<Object>> fields = collateResponseFields(response);
			Stream<Field> keyStream = fields.keySet().stream().filter(classField -> classField.isAnnotationPresent(InjectAPI.class));
			
			keyStream.forEach(field ->
			{
				Class<?> fieldType = field.getType();
				System.out.println(fieldType.getSimpleName());
				
				if(IRestAPI.class.isAssignableFrom(fieldType) && fieldType.isAssignableFrom(this.session.getAPI().getClass()))
				{
					if(field.trySetAccessible())
					{
						List<Object> owners = fields.get(field);
						
						for(Object owner : owners)
						{
							try 
							{
								field.set(owner, this.session.getAPI());
							} 
							catch (IllegalArgumentException | IllegalAccessException e) 
							{
								e.printStackTrace();
							}
						}
					}
				}
			});
		} 
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		
		return true;
	}

	private Map<Field, List<Object>> collateResponseFields(Response response) throws IllegalArgumentException, IllegalAccessException
	{
		Map<Field, List<Object>> list = new HashMap<>();
		
		collateFields(list, response);
		
		return list;
	}
	
	private void collateFields(Map<Field, List<Object>> fieldList, Object obj) throws IllegalArgumentException, IllegalAccessException
	{
		if(obj == null)
			return;
		
		Class<?> objClass = obj.getClass();
		//System.out.println(objClass.getSimpleName());
		
		if(objClass.isArray())
		{
			int length = Array.getLength(obj);
			
			for(int i = 0; i < length; i++)
			{
				Object arrayObj = Array.get(obj, i);
				
				collateFields(fieldList, arrayObj);
			}
		}
		else if(IRestEntity.class.isAssignableFrom(objClass))
		{
			for(Field field : obj.getClass().getDeclaredFields())
			{
				collateFields(fieldList, obj, field);
			}
		}
	}
	
	private void collateFields(Map<Field, List<Object>> fieldList, Object fieldOwner, Field field) throws IllegalArgumentException, IllegalAccessException
	{
		if(!field.trySetAccessible())
		{
			return;
		}
		
		Object fieldValue = field.get(fieldOwner);
		
		if(!fieldList.containsKey(field))
			fieldList.put(field, new ArrayList<>());
		
		fieldList.get(field).add(fieldOwner);
			
		collateFields(fieldList, fieldValue);
		//System.out.println(String.format("%s %s", fieldType.getSimpleName(), field.getName()));
	}
}