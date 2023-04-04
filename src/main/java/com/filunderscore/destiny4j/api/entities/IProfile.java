package com.filunderscore.destiny4j.api.entities;

import java.util.Date;
import java.util.Set;

public interface IProfile 
{
	Date getDateLastPlayed();
	
	Set<Expansion> getVersionsOwned();
}