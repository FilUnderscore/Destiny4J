package com.filunderscore.destiny4j.api.entities.user;

import java.util.Date;

public interface IBungieNetUser 
{
	long getMembershipId();
	
	String getUniqueName();
	String getNormalizedName();
	
	String getDisplayName();
	
	// TODO: Profile Picture, Profile Theme, User Title, Success message flags
	
	boolean isDeleted();
	
	String getAbout();
	
	Date getFirstAccess();
	Date getLastUpdate();
	
	Long getLegacyPortalUID();

	// TODO: Context
	
	String getPSNDisplayName();
	String getXboxDisplayName();
	String getFBDisplayName();
	
	Boolean doesShowActivity();
	
	String getLocale();
	
	boolean doesLocaleInheritDefault();
	
	Long getLastBanReportId();
	
	boolean hasShowGroupMessaging();
	
	String getProfilePicturePath();
	String getProfilePictureWidePath();
	
	String getProfileThemeName();
	String getUserTitleDisplay();
	
	String getStatusText();
	Date getStatusDate();
	
	Date getProfileBanExpire();
	
	String getBlizzardDisplayName();
	String getSteamDisplayName();
	String getStadiaDisplayName();
	String getTwitchDisplayName();
	
	String getCachedBungieGlobalDisplayName();
	Byte getCachedBungieGlobalDisplayNameCode();
	
	String getEGSDisplayName();
}