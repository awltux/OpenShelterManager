package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.Client;
import com.awltux.opensheltermanager.ReferralCategoryEnum;
import com.awltux.opensheltermanager.Referral;
import com.awltux.opensheltermanager.ReferralStatusEnum;
import com.awltux.opensheltermanager.ReferredBy;

import grails.test.mixin.TestFor
import groovy.mock.interceptor.MockFor;
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Referral)
class ReferralSpec extends ConstraintUnitHelperSpec {

    def setup() {
		// Mock the validation method
		mockForConstraintsTests(Referral)
    }

    def cleanup() {
    }
	
	void "test Referral.received constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Referral("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'received'			| null
			'valid'			| 'received'			| getDate()

	}
	
	void "test Referral.refferedBy constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Referral("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'refferedBy'			| null
			'valid'			| 'refferedBy'			| new ReferredBy()

	}
	
	void "test Referral.carenapAvailable constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Referral("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'carenapAvailable'			| null
			'valid'			| 'carenapAvailable'			| Boolean.FALSE

	}
	
	void "test Referral.category constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Referral("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'category'			| null
			'valid'			| 'category'			| ReferralCategoryEnum.BEHAVIOURAL_ISSUES

	}
	
	void "test Referral.status constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Referral("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'status'			| null
			'valid'			| 'status'			| ReferralStatusEnum.REVIEWING

	}
	
	void "test Referral.client constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Referral("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'client'			| null
			'valid'			| 'client'			| new Client()

	}

}
