package com.awltux.opensheltermanager

class Room {
	String name
	String description = ""
	BigDecimal rentalRate = 0
	
	Shelter shelter
	static belongsTo = [shelter:Shelter]

	List<Admission> occupancy = []
	static hasMany = [occupancy:Admission]
	
	public String toString() {
		return name
	}

    static constraints = {
		id(display:false)
		
		name(nullable:false, size:1..50)
		description(nullable:true, blank:true, maxSize:1000)
		rentalRate(nullable:false, min:0.00)
		shelter(nullable:false)
		occupancy(nullable:true, editable:false)
    }
}
