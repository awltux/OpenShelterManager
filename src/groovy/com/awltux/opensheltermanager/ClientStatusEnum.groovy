package com.awltux.opensheltermanager

enum ClientStatusEnum {
	INACTIVE("INAC"),
	RESIDENTIAL("RESI"),
	SUPPORTED("SUPP"),
	PLANNED_EXIT("PLND"),
	UNPLANNED_EXIT("UNPL"),
	TRANSFERRED("TRAN"),
	CUSTODY_HOSPITAL("UNAV"),
	NON_ENGAGEMENT("NENG")
	
	private final String id
	
	public ClientStatusEnum(String id){
		this.id = id
	}

}
