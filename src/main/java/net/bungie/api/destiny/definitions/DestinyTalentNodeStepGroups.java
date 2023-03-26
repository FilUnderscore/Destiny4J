package net.bungie.api.destiny.definitions;

public class DestinyTalentNodeStepGroups 
{
	public int weaponPerformance;
	public int impactEffects;
	public int guardianAttributes;
	public int lightAbilities;
	public int damageTypes;
	
	public DestinyTalentNodeStepWeaponPerformances getWeaponPerformance()
	{
		return new DestinyTalentNodeStepWeaponPerformances(this.weaponPerformance);
	}
	
	public DestinyTalentNodeStepImpactEffects getImpactEffects()
	{
		return new DestinyTalentNodeStepImpactEffects(this.impactEffects);
	}
	
	public DestinyTalentNodeStepGuardianAttributes getGuardianAttributes()
	{
		return new DestinyTalentNodeStepGuardianAttributes(this.guardianAttributes);
	}
	
	public DestinyTalentNodeStepLightAbilities getLightAbilities()
	{
		return new DestinyTalentNodeStepLightAbilities(this.lightAbilities);
	}
	
	public DestinyTalentNodeStepDamageTypes getDamageTypes()
	{
		return new DestinyTalentNodeStepDamageTypes(this.damageTypes);
	}
}