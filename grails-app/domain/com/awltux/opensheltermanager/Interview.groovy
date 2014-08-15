package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.InterviewStatusEnum;

class Interview {
	Date date = new Date()
    Date dateCreated
	Boolean createdInRetrospect
	Staff interviewedBy
	String notes = ""
	InterviewStatusEnum status = InterviewStatusEnum.PLANNED
	
	Client client
	static belongsTo = [client:Client]
	static transients = [createdInRetrospect:Boolean]
	
	public Boolean getCreatedInRetrospect() {
		Boolean inRetrospect = false
		if((!isAttached()) && date && dateCreated){
			inRetrospect = date.before(dateCreated)
		}
	    return inRetrospect
	}
	
	public String toString() {
		return date?.format("yyyy/MM/dd") + ' [' + status + ']';
	}
    static constraints = {
		id(display:false)
		dateCreated(display:false)
		
		client(nullable:false)
		interviewedBy(nullable:false)
		date(nullable:false)
		status(nullable:false, validator: { val, obj -> validatorStatus(val, obj) })
		notes(nullable:false, maxSize:1000)
		createdInRetrospect(attributes:[disabled:true])
    }
	
	private static validatorStatus(InterviewStatusEnum status, Interview obj) {
		if(!obj.isAttached() && (InterviewStatusEnum.PLANNED != status)) {
			return ['interviewsMustBeCreatedInPlannedState']
		}
	}
	
}
