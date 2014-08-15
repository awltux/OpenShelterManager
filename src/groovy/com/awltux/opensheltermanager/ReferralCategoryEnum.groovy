package com.awltux.opensheltermanager

enum ReferralCategoryEnum {
	NO_ACCOMODATION("NOAC"),
	SECURITY_OF_TENURE("STEN"),
	LEFT_CARE("LEFT"),
	DRUG_ALCOHOL_ISSUES("DRUG"),
	MENTAL_HEALTH_ISSUES("PSYC"),
	BEHAVIOURAL_ISSUES("BEHV"),
	DOMESTIC_ABUSE("DOMA"),
	OTHER("OTHR")
	
	private final String id
	
	public ReferralCategoryEnum(String id){
		this.id = id
	}

}
