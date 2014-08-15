package com.awltux.opensheltermanager

import groovy.time.TimeCategory
import groovy.time.TimeDuration
import java.util.Calendar

class Admission {
	Date arrival = new Date()
	Date departure
	Integer weeksBetweenPayments = 1
	DayOfWeekEnum paymentDay = DayOfWeekEnum.MONDAY
	Room room
	
	// FIXME[with Grails 2.4.1]: To work around GRAILS-10727
	List<Payment> payments = []
	BigDecimal totalPayedToDate
	
	BigDecimal getTotalPayedToDate() {
		BigDecimal total = 0
		payments?.each {
			total = total + it.amount
		}
		return total
	}
	
	BigDecimal totalOutstanding
	BigDecimal getTotalOutstanding() {
		final Date today = new Date()
		// Calculate current owed amount using payment schedule 
		// e.g. Only pay every 3rd Monday means 
		// nothing owed until the first instance of this after admission
		BigDecimal totalPayed = getTotalPayedToDate()
		
		// End Date is either a departure date in the past or today.
		Date endDate = departure && (departure.before(today)) ? departure : today
		
		BigDecimal outstanding = 0.0
		Integer daysWithinPaymentSchedule = 0
		if(departure && (departure.before(today))){
    		// if departure date is in the past, calculate the whole thing
			daysWithinPaymentSchedule = endDate - arrival
		} else {
			// Have to calculate the last payment day before we can figure out daysOccupancy
			// Find number of payment days 
			daysWithinPaymentSchedule = paymentDay.countDaysUntilLast(arrival, endDate, weeksBetweenPayments)
		}
		
		BigDecimal rentalRate = 0
		if (room?.rentalRate) {
			rentalRate = room?.rentalRate
		}
		BigDecimal totalCost = daysWithinPaymentSchedule * rentalRate
		outstanding = (totalCost - totalPayed)

		return outstanding
	}
	
	List<SupportProvided> supportProvided = []
	static hasMany = [payments:Payment, supportProvided:SupportProvided]
	static transients = ['totalPayedToDate', 'totalOutstanding']
	
	Client client	// Declared to allow constraints
	static belongsTo = [client:Client]

	public String toString() {
		return arrival?.format("yyyy/MM/dd") + ' [' + client?.name + ' in '+ room + ']';
	}

    static constraints = {
		id(display:false)
		client(nullable:false, validator: { val, obj ->  validatorClient(val, obj) } )
		room(nullable:false)
		arrival(nullable:false)
		departure(nullable:true, validator: { val, obj ->  validatorDeparture(val, obj) } )
		weeksBetweenPayments(nullable:false, min: 1)
		paymentDay(nullable:false)
		payments(nullable:true)
		totalPayedToDate(editable:false)
		totalOutstanding(editable:false)
		supportProvided(nullable:true)
    }

	private static validatorDeparture(Date departureDate, Admission obj) {
		if(departureDate && (departureDate < obj?.arrival)) {
			return ['departureBeforeArrival', obj?.arrival.format("yyyy/MM/dd")]
		}
	}
	
	private static validatorClient(Client client, Admission obj) {
		if(client && (ClientStatusEnum.RESIDENTIAL != client.status )) {
			return ['cannotAdmitIfNotResidential', client.status ]
		}
	}
	
}
