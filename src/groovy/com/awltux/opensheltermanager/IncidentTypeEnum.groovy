package com.awltux.opensheltermanager

enum IncidentTypeEnum {
	DRUGS("DRGS"),
	OTHER("OTHR")
	
	private final String id
	
	public IncidentTypeEnum(String id){
		this.id = id
	}

}
