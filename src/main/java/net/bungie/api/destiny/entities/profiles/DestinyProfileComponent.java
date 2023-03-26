package net.bungie.api.destiny.entities.profiles;

import java.util.Date;

import net.bungie.api.user.UserInfoCard;

public class DestinyProfileComponent
{
	public UserInfoCard userInfo;
	public Date dateLastPlayed;
	public int versionsOwned;
	public long[] characterIds;
	public long[] seasonHashes;
	public long currentSeasonHash;
	public int currentSeasonRewardPowerCap;
}