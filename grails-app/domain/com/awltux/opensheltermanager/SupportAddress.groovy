package com.awltux.opensheltermanager

class SupportAddress {
	SupportAddressStatusEnum status = SupportAddressStatusEnum.ACTIVE
	String address1
	String address2
	String postalTown
	String region
	String postCode
	
	Client client
	static belongsTo = [client:Client]

	// FIXME[with Grails 2.4.1]: To work around GRAILS-10727
//	List<Visit> visits = [] 
	List<VisitAgreement> visitAgreements = [] 

	public String toString() {
		return address1 + ', ' + postCode ;
	}
	
	static hasMany = [visitAgreements:VisitAgreement]
	
    static constraints = {
		id(display:false)
		
		status(nullable:false)
		address1(nullable:false, blank:false, maxSize:50)
		address2(nullable:true, maxSize:50)
		postalTown(nullable:false, blank:false, maxSize:50)
		region(nullable:true, maxSize:50)
		postCode(nullable:false, blank:false, maxSize:10)
		client(nullable:false)
//		visits(nullable:true)
		visitAgreements(nullable:true)
		
    }
}
