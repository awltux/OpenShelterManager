package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.Admission;
import com.awltux.opensheltermanager.Client;
import com.awltux.opensheltermanager.DayOfWeekEnum;
import com.awltux.opensheltermanager.Payment;
import com.awltux.opensheltermanager.Room;
import com.awltux.opensheltermanager.SupportProvided;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Admission)
class AdmissionSpec extends ConstraintUnitHelperSpec {

    def setup() {
		mockForConstraintsTests(Admission)
    }

    def cleanup() {
    }

	void "test Admission.arrival constraints"(error, field, val) {
		when: "Attribute is initialised"
			def obj = new Admission("${field}": val )

		then: "Validate constraint from table"
			validateConstraints(obj, field, error)
			
		where:
			error			| field				| val
			'nullable'		| 'arrival'			| null
			'valid'			| 'arrival'			| getDate()

	}
	
	void "test Admission.departure constraints"(error, field, val) {
		when: "Attribute is initialised"
			def obj = new Admission("${field}": val, arrival: new Date() )

		then: "Validate constraint from table"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'valid'		| 'departure'			| null
			'admission.departure.beforearrival.error'			| 'departure'			| getDate(-100000)
			'valid'			| 'departure'			| getDate(100000)
			
	}
	
	void "test Admission.weeksBetweenPayments constraints"(error, field, val) {
		when: "Attribute is initialised"
			def obj = new Admission("${field}": val )

		then: "Validate constraint from table"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'weeksBetweenPayments'			| null
			'min'			| 'weeksBetweenPayments'			| 0
			'valid'			| 'weeksBetweenPayments'			| 1
			
	}
	
	void "test Admission.paymentDay constraints"(error, field, val) {
		when: "Attribute is initialised"
			def obj = new Admission("${field}": val )

		then: "Validate constraint from table"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'paymentDay'			| null
			'valid'			| 'paymentDay'			| DayOfWeekEnum.THURSDAY
			
	}
	
	void "test Admission.room constraints"(error, field, val) {
		when: "Attribute is initialised"
			def obj = new Admission("${field}": val )

		then: "Validate constraint from table"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'room'			| null
			'valid'			| 'room'			| new Room()
			
	}
	
	void "test Admission.payments constraints"(error, field, val) {
		when: "Attribute is initialised"
			def obj = new Admission("${field}": val )

		then: "Validate constraint from table"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'payments'			| null
			'valid'			| 'payments'			| new Payment()
			
	}
	
	void "test Admission.supportProvided constraints"(error, field, val) {
		when: "Attribute is initialised"
			def obj = new Admission("${field}": val )

		then: "Validate constraint from table"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'supportProvided'			| null
			'valid'			| 'supportProvided'			| new SupportProvided()
			
	}
	
	void "test Admission.client constraints"(error, field, val) {
		when: "Attribute is initialised"
			def obj = new Admission("${field}": val )

		then: "Validate constraint from table"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'client'			| null
			'valid'			| 'client'			| new Client()
			
	}
	
}
