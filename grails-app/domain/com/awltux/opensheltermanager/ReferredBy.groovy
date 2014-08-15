package com.awltux.opensheltermanager

import java.util.List;

import com.awltux.opensheltermanager.ReferralOrganisationEnum;

class ReferredBy {
	ReferralOrganisationEnum referralOrganisation
	String contactName
	String contactNotes
	Boolean validContact = Boolean.TRUE
	List<Referral> referralsSubmitted = []
	
	static hasMany = [
		referralsSubmitted:Referral
	]

	public String toString() {
		return contactName + '[' + referralOrganisation + ']'
	}

    static constraints = {
		id(display:false)
		
		referralOrganisation(nullable:false, size:1..4)
		contactName(nullable:false, blank:false, size:1..50)
		contactNotes(nullable:true, maxSize:1000)
		validContact(nullable:false)

		referralsSubmitted(nullable:true)
    }
}
