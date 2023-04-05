package com.filunderscore.destiny4j.api;

import com.filunderscore.destiny4j.api.entities.app.IApplication;
import com.filunderscore.destiny4j.api.rest.IRestAPI;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IAppAPI extends IRestAPI
{
	/**
	 * GET: /App/FirstParty/
	 * 
	 * @return Get list of applications created by Bungie.
	 */
	IRestRequest<IApplication[]> getBungieApplications();
}