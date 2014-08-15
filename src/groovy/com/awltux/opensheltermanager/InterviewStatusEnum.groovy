package com.awltux.opensheltermanager

enum InterviewStatusEnum {
	PLANNED("PLAN"),
	MISSED("MISS"),
	RESCHEDULED("RSCH")
	
	private final String id
	
	public InterviewStatusEnum(String id){
		this.id = id
	}

}
