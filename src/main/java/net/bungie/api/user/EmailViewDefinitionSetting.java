package net.bungie.api.user;

import java.util.Map;

public class EmailViewDefinitionSetting 
{
	public String name;
	public Map<String, EMailSettingLocalization> localization;
	public boolean setByDefault;
	public long optInAggregateValue;
	public EmailSubscriptionDefinition[] subscriptions;
}