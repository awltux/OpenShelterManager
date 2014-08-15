package com.awltux.opensheltermanager

import grails.test.mixin.TestFor
import spock.lang.Specification

//FIXME: Added to work around GRAILS-10474
import grails.test.mixin.web.ControllerUnitTestMixin

import org.codehaus.groovy.grails.plugins.databinding.DataBindingGrailsPlugin

import com.awltux.opensheltermanager.Room;
@TestMixin(ControllerUnitTestMixin)
//END FIXME
@TestFor(Room)
class RoomSpec extends ConstraintUnitHelperSpec {

    def setup() {
		//FIXME: Added to work around GRAILS-10474
		defineBeans(new DataBindingGrailsPlugin().doWithSpring)
		//END FIXME
 		// Mock the validation method
		mockForConstraintsTests(Room)
    }

    def cleanup() {
    }

	void "test Room.name constraints" ( error,  field,  val) {
		
		when: "we create a Room using field and value from fixture"
			def obj = new Room("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'name'			| null
			'valid'			| 'name'			| '1'
			'valid'			| 'name'			| getLongString(50)
			'size'			| 'name'			| getLongString(51)
	}
	
	void "GRAILS_BUG.test Room.name.blank constraints" ( error,  field,  val) {
		
		when: "we create a Room using field and value from fixture"
			def obj = new Room("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture: FIXME: empty string throws nullable"
			error			| field				| val
			'size'			| 'name'			| ''
	}
	
	void "test Room.description constraints" ( error,  field,  val) {
		
		when: "we create a Room using field and value from fixture"
			def obj = new Room("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture: FIXME: empty string throws nullable"
			error			| field				| val
			'valid'			| 'description'			| null
			'valid'			| 'description'			| getLongString(1000)
			'maxSize'			| 'description'			| getLongString(1001)
			'valid'		| 'description'			| ''
	}
	
	void "test Room.rentalRate constraints" ( error,  field,  val) {
		
		when: "we create a Room using field and value from fixture"
			def obj = new Room("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture: FIXME: empty string throws nullable"
			error			| field				| val
			'nullable'		| 'rentalRate'			| null
			'min'			| 'rentalRate'			| -0.01f
			'valid'			| 'rentalRate'			| 0.00f
	}
	
	void "test Room.shelter constraints" ( error,  field,  val) {
		
		when: "we create a Room using field and value from fixture"
			def obj = new Room("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture: FIXME: empty string throws nullable"
			error			| field				| val
			'nullable'			| 'shelter'			| null
			'valid'			| 'shelter'			| new Shelter()
	}
	
}
