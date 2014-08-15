package com.awltux.opensheltermanager

enum StaffStatusEnum {
	INACTIVE("INAC"),
	ACTIVE("ACTV")
		
	private final String id
	
	public StaffStatusEnum(String id){
		this.id = id
	}

}
