package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.Client;
import com.awltux.opensheltermanager.Staff;
import com.awltux.opensheltermanager.SupportAddress;
import com.awltux.opensheltermanager.Visit;
import com.awltux.opensheltermanager.VisitAgreement;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(SupportAddress)
class SupportAddressSpec extends ConstraintUnitHelperSpec {

    def setup() {
		mockForConstraintsTests(SupportAddress)
    }

    def cleanup() {
    }

	void "test SupportAddress.address1 constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'address1'			| null
			'maxSize'			| 'address1'			| getLongString(51)
			'valid'			| 'address1'			| getLongString(50)
			
	}
	
	void "GRAILS_BUG.test SupportAddress.address1.blank constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'blank'			| 'address1'			| ''
			
	}
	
	void "test SupportAddress.address2 constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'valid'		   	| 'address2'			| null
			'valid'		 	| 'address2'			| ''
			'maxSize'		| 'address2'			| getLongString(51)
			'valid'			| 'address2'			| getLongString(50)
			
	}
	
	void "test SupportAddress.postalTown constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'postalTown'			| null
			'maxSize'			| 'postalTown'			| getLongString(51)
			'valid'			| 'postalTown'			| getLongString(50)
			
	}
	
	void "GRAILS_BUG:test SupportAddress.postalTown.blank constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'blank'			| 'postalTown'			| ''
			
	}
	
	void "test SupportAddress.region constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'valid'			| 'region'			| null
			'valid'			| 'region'			| ''
			'maxSize'		| 'region'			| getLongString(51)
			'valid'			| 'region'			| getLongString(50)
			
	}
	
	void "test SupportAddress.postCode constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'postCode'			| null
			'maxSize'		| 'postCode'			| getLongString(11)
			'valid'			| 'postCode'			| getLongString(10)
			
	}
	
	void "GRAILS_BUG: test SupportAddress.postCode.blank constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'blank'			| 'postCode'			| ''
	}
	
	void "test SupportAddress.client constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'client'			| null
			'valid'			| 'client'			| new Client()
			
	}
	
	void "test SupportAddress.visits constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'visits'			| null
			'valid'			| 'visits'			| []
			'valid'			| 'visits'			| [new Visit()]
			
	}
	
	void "test SupportAddress.visitAgreements constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new SupportAddress("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field						| val
			'nullable'		| 'visitAgreements'			| null
			'valid'			| 'visitAgreements'			| []
			'valid'			| 'visitAgreements'			| [new VisitAgreement()]
			
	}
	

}
