package com.awltux.opensheltermanager

class SupportWorker {
	Date start
	Date end
	Staff staff	
	Client client
	static belongsTo = [client:Client]
	
 	public String toString() {
		return staff + ' [ FOR: ' + client + ']' ;
	}

	static constraints = {
		id(display:false)

		// must be set and be in the past
		start(nullable:false, validator: {it <= new Date()})
		
		// only set at end of support e.g.
		// 		- Staff is set to inactive
		//      - Client leaves support systems
		end(nullable:true)
		
		//Must have a staff object
		staff(nullable:false)
		
		//Must have a client object
		client(nullable:false)
    }
}
