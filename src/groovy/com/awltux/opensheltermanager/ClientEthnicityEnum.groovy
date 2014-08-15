package com.awltux.opensheltermanager

enum ClientEthnicityEnum {
	WHITE_UK("WHUK"),
	MIXED("MIXD"),
	ASIAN_UK("ASUK"),
	AFRICAN_CARIBBEAN_SCOTTISH("ACSC"),
	WHITE_EUROPEAN("WHEU"),
	ASIAN_SCOTTISH("ASSC"),
	AFRICAN_CARIBBEAN("AFCB"),
	AFRICAN_CARIBBEAN_UK("ACUK"),
	OTHER("OTHR")
	
	private final String id
	
	public ClientEthnicityEnum(String id){
		this.id = id
	}

}
