package com.awltux.opensheltermanager

class SupportProvided {
	Float hoursProvided = 0.0f
	Date day = new Date()
	
    static constraints = {
		id(display:false)
		
		hoursProvided(nullable:false, min:0.0f)
		day(nullable:false)
    }
}
