package net.bungie.api;

import java.util.Map;

import net.bungie.api.common.models.CoreSetting;
import net.bungie.api.common.models.CoreSystem;
import net.bungie.api.common.models.Destiny2CoreSettings;
import net.bungie.api.user.EmailSettings;

public class CoreSettingsConfiguration 
{
	public String environment;
	public Map<String, CoreSystem> systems;
	public CoreSetting[] ignoreReasons;
	public CoreSetting[] forumCategories;
	public CoreSetting[] groupAvatars;
	public CoreSetting[] destinyMembershipTypes;
	public CoreSetting[] recruitmentPlatformTags;
	public CoreSetting[] recruitmentMiscTags;
	public CoreSetting[] recruitmentActivities;
	public CoreSetting[] userContentLocales;
	public CoreSetting[] systemContentLocales;
	public CoreSetting[] clanBannerDecals;
	public CoreSetting[] clanBannerDecalColors;
	public CoreSetting[] clanBannerGonfalons;
	public CoreSetting[] clanBannerGonfalonColors;
	public CoreSetting[] clanBannerGonfalonDetails;
	public CoreSetting[] clanBannerStandards;
	public Destiny2CoreSettings destiny2CoreSettings;
	public EmailSettings emailSettings;
	public CoreSetting[] fireteamActivities;
}