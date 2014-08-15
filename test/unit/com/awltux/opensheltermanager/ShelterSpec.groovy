package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.Room;
import com.awltux.opensheltermanager.Shelter;
import com.awltux.opensheltermanager.Staff;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Shelter)
class ShelterSpec extends ConstraintUnitHelperSpec {

    def setup() {
		mockForConstraintsTests(Shelter)
    }

    def cleanup() {
    }

	void "test Shelter.name constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Shelter("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'name'			| null
			'size'			| 'name'			| getLongString(101)
			'valid'			| 'name'			| getLongString(1)
			'valid'			| 'name'			| getLongString(100)
			
	}
	
	void "GRAILS_BUG.test Shelter.name.blank constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Shelter("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'size'			| 'name'			| ''
	}
	
	void "test Shelter.buildingNumberOrName constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Shelter("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'valid'		| 'buildingNumberOrName'			| null
			'size'			| 'buildingNumberOrName'			| getLongString(101)
			'valid'			| 'buildingNumberOrName'			| getLongString(1)
			'valid'			| 'buildingNumberOrName'			| getLongString(100)
			
	}
	
	void "GRAILS_BUG.test Shelter.buildingNumberOrName.blank constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Shelter("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'size'			| 'buildingNumberOrName'			| ''
			
	}
	
	void "test Shelter.postcode constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Shelter("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'valid'		| 'postcode'			| null
			'size'			| 'postcode'			| getLongString(11)
			'valid'			| 'postcode'			| getLongString(1)
			'valid'			| 'postcode'			| getLongString(10)
			
	}
	
	void "GRAILS_BUG.test Shelter.postcode.blank constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Shelter("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'size'			| 'postcode'			| ''
	}
	
	void "test Shelter.staff constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Shelter("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'staff'			| null
			'valid'			| 'staff'			| []
			'valid'			| 'staff'			| [new Staff()]
			
	}
	
	void "test Shelter.rooms constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Shelter("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'rooms'			| null
			'valid'			| 'rooms'			| []
			'valid'			| 'rooms'			| [new Room()]
			
	}
	
	void "test Shelter.referrals constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Shelter("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'valid'		| 'referrals'			| null
			'valid'			| 'referrals'			| []
			'valid'			| 'referrals'			| [new Staff()]
			
	}
	

}
