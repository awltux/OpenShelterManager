
package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.ReferralOrganisationEnum;
import com.awltux.opensheltermanager.ReferredBy;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.IllegalArgumentException;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ReferredBy)
class ReferredBySpec extends ConstraintUnitHelperSpec {

    def setup() {
		mockForConstraintsTests(ReferredBy)
    }

    def cleanup() {
    }

	void "test ReferredBy.referralOrganisation constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new ReferredBy("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'referralOrganisation'			| null
			'valid'			| 'referralOrganisation'			| ReferralOrganisationEnum.FAMILY

	}
	
	void "test ReferredBy.contactName constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new ReferredBy("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'contactName'			| null
			'nullable'		| 'contactName'			| ''
			'size'			| 'contactName'			| getLongString(51)
			'valid'			| 'contactName'			| getLongString(50)
			'valid'			| 'contactName'			| getLongString(1)
			
	}
	
	void "test ReferredBy.active constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new ReferredBy("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'active'			| null
			'valid'			| 'active'			| Boolean.FALSE

	}
	
}
