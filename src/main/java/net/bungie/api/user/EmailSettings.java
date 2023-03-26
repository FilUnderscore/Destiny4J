package net.bungie.api.user;

import java.util.Map;

public class EmailSettings 
{
	public Map<String, EmailOptInDefinition> optInDefinitions;
	public Map<String, EmailSubscriptionDefinition> subscriptionDefinitions;
	public Map<String, EmailViewDefinition> views;
}