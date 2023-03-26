package net.bungie.api.destiny.milestones;

import java.util.Date;

public class DestinyPublicMilestone 
{
	public long milestoneHash;
	public DestinyPublicMilestoneQuest[] availableQuests;
	public DestinyPublicMilestoneChallengeActivity[] activities;
	public long[] vendorHashes;
	public DestinyPublicMilestoneVendor[] vendors;
	public Date startDate;
	public Date endDate;
	public int order;
}