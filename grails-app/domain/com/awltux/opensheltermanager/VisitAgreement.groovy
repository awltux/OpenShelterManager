package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.DayOfWeekEnum
import org.joda.time.LocalDate
import org.joda.time.LocalDate

class VisitAgreement {
	LocalDate startDate = new LocalDate()
	LocalDate endDate
	DayOfWeekEnum preferredVisitDay = DayOfWeekEnum.MONDAY
	Integer agreedMinutesDuration
	SupportAddress address
	
	List<Visit> visits = []
	static hasMany = [visits:Visit]

	public String toString() {
		return agreedMinutesDuration?.toString() + "min on " + preferredVisitDay?.toString();
	}
	
    static constraints = {
		id(display:false)
		
		address(nullable:false,
		    validator: { val, VisitAgreement obj ->
			    return validateAddress(val, obj)
		    }
		)
		startDate(nullable:false, format:'yyyy/MM/dd')
		endDate(nullable:true, format:'yyyy/MM/dd',
		    validator: { val, VisitAgreement obj ->
			    return validateEndDate(val, obj)
		    }
		)
		preferredVisitDay(nullable:false)
		
		// min and max only seems to work on integer values. A limitation of the underlying input field.
		agreedMinutesDuration(nullable:false, min: 5, max: 240)
    }
	
	private static validateEndDate(LocalDate endDate, VisitAgreement obj){
		if(endDate){ // optional field, so check if set
    		LocalDate latestVisit = endDate
			obj.visits.each { Visit visit ->
				if(visit.date > endDate) latestVisit = visit.date 
			}
			
			if (latestVisit > endDate) {
				return ['endDataConflictsWithVisits', latestVisit]
			}

			if (obj.startDate > endDate) {
				return ['endDataBeforeStartDate', obj.startDate.toString("yyyy/MM/dd")]
			}
		}
	}

	private static validateAddress(SupportAddress address, VisitAgreement obj){
		if(address.status == SupportAddressStatusEnum.INACTIVE)
    		return ['supportAddressInactive', address.toString()]
	}
}
