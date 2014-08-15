package com.awltux.opensheltermanager
import org.joda.time.LocalDate
import org.joda.time.LocalTime


class Visit {
	VisitAgreement visitAgreement
	LocalDate date
	LocalTime time
	Integer duration
	
	public String toString() {
		return date?.toString("yyyy/MM/dd") + '@' + time?.toString('HH:mm') + ' for ' + duration + 'min' ;
	}

	public SupportAddress getSupportAddress(){
		return visitAgreement?.getAddress()
	}
	
	static transients = [ 'supportAddress' ]
	
    static constraints = {
		id(display:false)
		
		visitAgreement(nullable:false)
		date(nullable:false, 
			format:'yyyy/MM/dd', 
		    validator: { val, Visit obj ->
			    return validateDate(val, obj)
		    })
		time(nullable:false)
		duration(nullable:false, validator: { val, Visit obj ->
			if( val > obj.visitAgreement?.agreedMinutesDuration) 
				return ['visitTooLong']
		})
    }
	
	private static validateDate(LocalDate val, Visit obj){
		def visitAgreement = obj.visitAgreement

		LocalDate requestedDate = obj.date
		LocalDate earliestDate = visitAgreement?.getStartDate()
		LocalDate latestDate = visitAgreement?.getEndDate()
		if ( (earliestDate && earliestDate > requestedDate) || (latestDate && requestedDate > latestDate)) {
			// One of the dates is invalid
			String optionalEndDate = ''
			if(latestDate) {
				optionalEndDate = ' and earlier than ' + latestDate.toString("yyyy/MM/dd")
			} 
			return [ 'requestedDateOutsideVisitAgreementDates', earliestDate?.toString("yyyy/MM/dd"), optionalEndDate]
		}

		def preferredDow = visitAgreement?.preferredVisitDay
		def requestedDow = DayOfWeekEnum.getDayOfWeek(obj.date.getDayOfWeek())
		if( requestedDow != preferredDow) {
			return [ 'wrongDayOfTheWeek', requestedDow, preferredDow ]
		}
		
	}
	
}
