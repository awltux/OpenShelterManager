package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.Staff;
import com.awltux.opensheltermanager.SupportProvided;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(SupportProvided)
class SupportProvidedSpec extends ConstraintUnitHelperSpec {

    def setup() {
		mockForConstraintsTests(SupportProvided)
    }

    def cleanup() {
    }

	void "test SupportProvided.hoursProvided constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportProvided("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'hoursProvided'			| null
			'min'		    | 'hoursProvided'			| -0.01f
			'valid'			| 'hoursProvided'			| 0.0f
			
	}
	
	void "test SupportProvided.day constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportProvided("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'day'			| null
			'valid'			| 'day'			| new Date()
			
	}
	
	void "test SupportProvided.admission constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportProvided("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field				| val
			'nullable'		| 'admission'			| null
			'valid'			| 'admission'			| new Admission()
			
	}
	
	void "test SupportProvided.providedBy constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportProvided("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field				| val
			'nullable'		| 'providedBy'			| null
			'valid'			| 'providedBy'			| new Staff()
			
	}
	
}
