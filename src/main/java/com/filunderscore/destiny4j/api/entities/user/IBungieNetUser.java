package com.filunderscore.destiny4j.api.entities.user;

import java.util.Date;

public interface IBungieNetUser 
{
	long getMembershipId();
	
	String getUniqueName();
	String getNormalizedName();
	
	String getDisplayName();
	
	int getProfilePicture();
	int getProfileTheme();
	int getUserTitle();
	
	long getSuccessMessageFlags();
	
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
	Short getCachedBungieGlobalDisplayNameCode();
	
	String getEGSDisplayName();
}