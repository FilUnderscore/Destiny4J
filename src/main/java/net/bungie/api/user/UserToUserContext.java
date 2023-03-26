package net.bungie.api.user;

import java.util.Date;

import net.bungie.api.ignores.IgnoreResponse;

public class UserToUserContext 
{
	public boolean isFollowing;
	public IgnoreResponse ignoreStatus;
	public Date globalIgnoreEndDate;
}