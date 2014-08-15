package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.StaffStatusEnum;

class Staff {
	String name
	Shelter workPlace
	StaffStatusEnum status = StaffStatusEnum.ACTIVE;
	
	// FIXME[with Grails 2.4.1]: To work around GRAILS-10727
	List<SupportWorker> supportRoles = []
	List<SupportProvided> supportProvided = []
	List<Discipline> disciplinesHandled = []
	List<Interview> interviewDates = []
	List<Payment> paymentsTaken = []
	static hasMany = [paymentsTaken:Payment, interviewDates:Interview, supportRoles:SupportWorker, supportProvided:SupportProvided, disciplinesHandled:Discipline]

	public String toString() {
		return name
	}

    static constraints = {
		id(display:false)
		
		// Required and must be 1 to 50 characters long
		name(nullable:false, size:1..100)

		// Required 
		status(nullable:false)
		
		// Required 
		workPlace(nullable:false)
		
		// supportRoles collection must be initialised
		supportRoles(nullable:false)

		// supportProvided collection must be initialised
		supportProvided(nullable:true)

		// disciplinesHandled collection must be initialised
		disciplinesHandled(nullable:false)

		// disciplinesHandled collection must be initialised
		paymentsTaken(nullable:true)

    }
}
