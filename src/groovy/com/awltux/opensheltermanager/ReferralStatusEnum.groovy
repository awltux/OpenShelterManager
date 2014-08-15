package com.awltux.opensheltermanager

enum ReferralStatusEnum {
	REVIEWING("REVW"),
	ADMITTED("ADMT"),
	NEEDS_TOO_HIGH("NEED"),
	DECLINED_INTERVIEW("INTV"),
	PENDING_OFFER_ACCEPTANCE("PEND"),
	WAITING_FOR_VACANCY("VACY"),
	WITHDRAWN("WDRW"),
	PENDING_INFORMATION("INFO"),
	REFUSED_BY_SU("REFU")
	
	private final String id
	
	public ReferralStatusEnum(String id){
		this.id = id
	}

}
