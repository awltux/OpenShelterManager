package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.ReferralCategoryEnum;
import com.awltux.opensheltermanager.ReferralStatusEnum;

class Referral {
	Date received
	ReferredBy refferedBy
	Boolean carenapAvailable = Boolean.FALSE
	ReferralCategoryEnum category
	ReferralStatusEnum status = ReferralStatusEnum.REVIEWING
	Client client
	
	public String toString() {
		return received?.format("yyyy/MM/dd") + ' [' + status + ']';
	}

    static constraints = {
		id(display:false)
		
		// must have a client
		client(nullable:false, validator: { val, obj -> validatorClient(val, obj)})
		
		// Must have a category
		category(nullable:false)
		
		// Must have a status
		status(nullable:false, validator: { val, obj -> validatorStatus(val, obj) })
		
		// must have a received date and it must be in the past
		received(nullable:false, validator: {val, obj -> validatorReceived(val, obj) })
		
		//Must have a refferedBy 
		refferedBy(nullable:false)
		
		//Must be a valid Boolean
		carenapAvailable(nullable:false)
		
    }

	private static validatorReceived(Date received, Referral obj) {
		Date today = new Date()
		if(received > today) {
			return ['referralCannotBeReceivedInTheFuture']
		}
	}
	
	private static validatorClient(Client client, Referral obj) {
		if(!obj.isAttached() 
			&&    ( ClientStatusEnum.RESIDENTIAL == obj.client.status 
			     || ClientStatusEnum.SUPPORTED == obj.client.status )) {
			return ['existingClientCannotBeReferred']
		}
	}
	
	private static validatorStatus(ReferralStatusEnum status, Referral obj) {
		if((ReferralStatusEnum.ADMITTED == status)
			&&    ( ClientStatusEnum.RESIDENTIAL == obj.client.status 
			     || ClientStatusEnum.SUPPORTED == obj.client.status )) {
			return ['existingClientCannotBeAdmitted']
		}
	}
	

}
