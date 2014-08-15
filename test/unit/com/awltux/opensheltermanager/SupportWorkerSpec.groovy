package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.SupportWorker;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(SupportWorker)
class SupportWorkerSpec extends ConstraintUnitHelperSpec {

    def setup() {
		mockForConstraintsTests(SupportWorker)
    }

    def cleanup() {
    }

	void "test SupportWorker.start constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportWorker("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'start'			| null
			'valid'		    | 'start'			| getDate(-10000)
			'validator'		| 'start'			| getDate(10000)
			
	}
	
	void "test SupportWorker.end constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportWorker("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'valid'		| 'end'			| null
			'valid'		    | 'end'			| getDate(-10000)
			'valid'  		| 'end'			| getDate(10000)
			
	}
	
	void "test SupportWorker.staff constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportWorker("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'staff'			| null
			'valid'		    | 'staff'			| new Staff()
	}
	
	void "test SupportWorker.client constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportWorker("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'client'			| null
			'valid'		    | 'client'			| new Client()
	}
	
}
