package com.awltux.opensheltermanager

enum SupportAddressStatusEnum {
	INACTIVE("INAC"),
	ACTIVE("ACTV")
		
	private final String id
	
	public SupportAddressStatusEnum(String id){
		this.id = id
	}

}
