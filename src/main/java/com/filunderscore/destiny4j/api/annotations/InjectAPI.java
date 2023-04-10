package com.filunderscore.destiny4j.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/**
 * Used to inject the caller API into the entity implementation, 
 * gets injected from the parent entity.
 */
public @interface InjectAPI
{
}