package com.filunderscore.destiny4j.impl.entities.user;

import java.util.Date;

import com.filunderscore.destiny4j.api.entities.user.IBungieNetUser;

public final class BungieNetUser implements IBungieNetUser
{
	private long membershipId;
	
	private String uniqueName;
	private String normalizedName;
	private String displayName;
	
	private int profilePicture;
	private int profileTheme;
	
	private int userTitle;
	
	private long successMessageFlags;
	
	private boolean isDeleted;
	
	private String about;
	
	private Date firstAccess;
	private Date lastUpdate;
	
	private Long legacyPortalUID;
	
	// TODO: Context
	
	private String psnDisplayName;
	private String xboxDisplayName;
	private String fbDisplayName;

	private Boolean showActivity;
	
	private String locale;
	private boolean localeInheritDefault;
	
	private Long lastBanReportId;
	
	private boolean showGroupMessaging;
	
	private String profilePicturePath;
	private String profilePictureWidePath;
	
	private String profileThemeName;

	private String userTitleDisplay;
	
	private String statusText;
	private Date statusDate;
	
	private Date profileBanExpire;
	
	private String blizzardDisplayName;
	private String steamDisplayName;
	private String stadiaDisplayName;
	private String twitchDisplayName;
	
	private String cachedBungieGlobalDisplayName;
	private Short cachedBungieGlobalDisplayNameCode;
	
	private String egsDisplayName;

	@Override
	public long getMembershipId() 
	{
		return this.membershipId;
	}

	@Override
	public String getUniqueName() 
	{
		return this.uniqueName;
	}

	@Override
	public String getNormalizedName() 
	{
		return this.normalizedName;
	}

	@Override
	public String getDisplayName() 
	{
		return this.displayName;
	}

	@Override
	public int getProfilePicture() 
	{
		return this.profilePicture;
	}

	@Override
	public int getProfileTheme() 
	{
		return this.profileTheme;
	}

	@Override
	public int getUserTitle() 
	{
		return this.userTitle;
	}

	@Override
	public long getSuccessMessageFlags() 
	{
		return this.successMessageFlags;
	}

	@Override
	public boolean isDeleted() 
	{
		return this.isDeleted;
	}

	@Override
	public String getAbout() 
	{
		return this.about;
	}

	@Override
	public Date getFirstAccess() 
	{
		return this.firstAccess;
	}

	@Override
	public Date getLastUpdate() 
	{
		return this.lastUpdate;
	}

	@Override
	public Long getLegacyPortalUID() 
	{
		return this.legacyPortalUID;
	}

	@Override
	public String getPSNDisplayName() 
	{
		return this.psnDisplayName;
	}

	@Override
	public String getXboxDisplayName() 
	{
		return this.xboxDisplayName;
	}

	@Override
	public String getFBDisplayName() 
	{
		return this.fbDisplayName;
	}

	@Override
	public Boolean doesShowActivity() 
	{
		return this.showActivity;
	}

	@Override
	public String getLocale() 
	{
		return this.locale;
	}

	@Override
	public boolean doesLocaleInheritDefault() 
	{
		return this.localeInheritDefault;
	}

	@Override
	public Long getLastBanReportId() 
	{
		return this.lastBanReportId;
	}

	@Override
	public boolean hasShowGroupMessaging() 
	{
		return this.showGroupMessaging;
	}

	@Override
	public String getProfilePicturePath() 
	{
		return this.profilePicturePath;
	}

	@Override
	public String getProfilePictureWidePath() 
	{
		return this.profilePictureWidePath;
	}

	@Override
	public String getProfileThemeName() 
	{
		return this.profileThemeName;
	}

	@Override
	public String getUserTitleDisplay() 
	{
		return this.userTitleDisplay;
	}

	@Override
	public String getStatusText() 
	{
		return this.statusText;
	}

	@Override
	public Date getStatusDate() 
	{
		return this.statusDate;
	}

	@Override
	public Date getProfileBanExpire() 
	{
		return this.profileBanExpire;
	}

	@Override
	public String getBlizzardDisplayName() 
	{
		return this.blizzardDisplayName;
	}

	@Override
	public String getSteamDisplayName() 
	{
		return this.steamDisplayName;
	}

	@Override
	public String getStadiaDisplayName() 
	{
		return this.stadiaDisplayName;
	}

	@Override
	public String getTwitchDisplayName() 
	{
		return this.twitchDisplayName;
	}

	@Override
	public String getCachedBungieGlobalDisplayName() 
	{
		return this.cachedBungieGlobalDisplayName;
	}

	@Override
	public Short getCachedBungieGlobalDisplayNameCode() 
	{
		return this.cachedBungieGlobalDisplayNameCode;
	}

	@Override
	public String getEGSDisplayName() 
	{
		return this.egsDisplayName;
	}
}