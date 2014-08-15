package com.awltux.opensheltermanager

import java.util.List;

class Shelter {
	String name
	String buildingNumberOrName = ""
	String postcode = ""
	
	List<Staff> staff = []
	List<Room> rooms = []
	List<Referral> referrals = []
	static hasMany = [staff:Staff, rooms:Room, referrals:Referral]

	public String toString() {
		return name
	}

	static constraints = {
		id(display:false)
		
		name(nullable:false, size:1..100)
		buildingNumberOrName(nullable:true, size:1..100)
		postcode(nullable:true, size:1..10)
		staff(nullable:false)
		rooms(nullable:false)
		referrals(nullable:true)
    }
}
