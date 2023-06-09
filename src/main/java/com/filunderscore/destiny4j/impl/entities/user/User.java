package com.filunderscore.destiny4j.impl.entities.user;

import java.util.EnumSet;
import java.util.Set;

import com.filunderscore.destiny4j.api.IUserAPI;
import com.filunderscore.destiny4j.api.annotations.InjectAPI;
import com.filunderscore.destiny4j.api.entities.user.IUser;
import com.filunderscore.destiny4j.api.entities.user.membership.BungieMembershipType;
import com.filunderscore.destiny4j.api.entities.user.membership.IUserMembershipData;
import com.filunderscore.destiny4j.api.rest.IRestRequest;

public class User implements IUser
{
	@InjectAPI
	protected IUserAPI userAPI;
	
	private String supplementalDisplayName;
	private String iconPath;
	private int crossSaveOverride;
	private int[] applicableMembershipTypes;
	private boolean isPublic;
	private int membershipType;
	private long membershipId;
	private String displayName;
	private String bungieGlobalDisplayName;
	private Short bungieGlobalDisplayNameCode;
	
	@Override
	public String getSupplementalDisplayName() 
	{
		return this.supplementalDisplayName;
	}

	@Override
	public String getIconPath() 
	{
		return this.iconPath;
	}

	@Override
	public BungieMembershipType getCrossSaveOverride() 
	{
		return BungieMembershipType.fromIndex(this.crossSaveOverride);
	}

	@Override
	public Set<BungieMembershipType> getApplicableMembershipType() 
	{
		Set<BungieMembershipType> membershipTypesSet = EnumSet.noneOf(BungieMembershipType.class);
		
		for(int membershipType : this.applicableMembershipTypes)
		{
			membershipTypesSet.add(BungieMembershipType.fromIndex(membershipType));
		}
		
		return membershipTypesSet;
	}

	@Override
	public boolean isPublic() 
	{
		return this.isPublic;
	}

	@Override
	public BungieMembershipType getMembershipType() 
	{
		return BungieMembershipType.fromIndex(this.membershipType);
	}

	@Override
	public long getMembershipId() 
	{
		return this.membershipId;
	}

	@Override
	public String getDisplayName() 
	{
		return this.displayName;
	}

	@Override
	public String getBungieGlobalDisplayName() 
	{
		return this.bungieGlobalDisplayName;
	}

	@Override
	public Short getBungieGlobalDisplayNameCode() 
	{
		return this.bungieGlobalDisplayNameCode;
	}

	@Override
	public IRestRequest<IUserMembershipData> getMembershipData(BungieMembershipType type) 
	{	
		return this.userAPI.getMembershipDataById(this.membershipId, type.getValue());
	}

	/**
	 * Returns user membership data of the user's current membership (Not necessarily the native type.)
	 */
	@Override
	public IRestRequest<IUserMembershipData> getMembershipData() 
	{
		return this.getMembershipData(this.getMembershipType());
	}
}