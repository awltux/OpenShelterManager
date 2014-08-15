package com.awltux.opensheltermanager

import java.text.DecimalFormat

class Payment {
	BigDecimal amount = 0.00
	Date received = new Date()
	Staff receivedBy
	
	Admission admission 	// Declared to allow constraints
	static belongsTo = [admission:Admission]

 	public String toString() {
		return amount + ' [ FROM: ' + admission?.client?.name + ' ON: ' + received?.format("yyyy/MM/dd") + ']' ;
	}

   static constraints = {
		id(display:false)
		
		amount(nullable:false, blank:false, min:0.00, widget:'text')
		received(nullable:false, blank:false)
		receivedBy(nullable:false)
		admission(nullable:false)
    }
}
