package com.awltux.opensheltermanager

public enum ReferralOrganisationEnum {
	SELF("SELF"),
	HOUSING_OFFICER("HOFF"),
	HOSTELS("HOST"),
	SURESTART("SURE"),
	UNKNOWN("UNKN"),
	FAMILY("FAM"),
	YAT_YHT("YHT"),
	YAT_TCAC("TCAC"),
	OTHER_BETHANY_UNIT("BETH"),
	SOCIAL_WORK_DEPARTMENT("SWDP"),
	HOUSING_ASSOCIATION("HASS"),
	OTHER_SOURCE("OTHR")
	
	private final String id
	
	public ReferralOrganisationEnum(String id){
		this.id = id
	}
	

}
