package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.Shelter;
import com.awltux.opensheltermanager.Staff;
import com.awltux.opensheltermanager.StaffStatusEnum;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Staff)
class StaffSpec extends ConstraintUnitHelperSpec {

    def setup() {
		mockForConstraintsTests(Staff)
    }

    def cleanup() {
    }

	void "test Staff.name constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Staff("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'name'			| null
			'size'			| 'name'			| getLongString(101)
			'valid'			| 'name'			| getLongString(1)
			'valid'			| 'name'			| getLongString(100)
			
	}
	
	void "GRAILS_BUG.test Staff.name.blank constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Staff("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'size'			| 'name'			| ''
			
	}
	
	void "test Staff.workPlace constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Staff("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'workPlace'			| null
			'valid'			| 'workPlace'			| new Shelter()
			
	}
	
	void "test Staff.status constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Staff("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'status'			| null
			'valid'			| 'status'			| StaffStatusEnum.ACTIVE
			
	}
	
	void "test Staff.supportRoles constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Staff("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'supportRoles'			| null
			'valid'			| 'supportRoles'			| []
			'valid'			| 'supportRoles'			| [new Staff()]
			
	}
	

	void "test Staff.supportProvided constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Staff("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'supportProvided'			| null
			'valid'			| 'supportProvided'			| []
			'valid'			| 'supportProvided'			| [new Staff()]
			
	}
	

	void "test Staff.disciplinesHandled constraints"(error, field, val) {
		when: "Attributes are un-initialised"
			def obj = new Staff("${field}": val )

		then: "validation errors should exist"
			validateConstraints(obj, field, error)
			
		where:
			error			| field					| val
			'nullable'		| 'disciplinesHandled'			| null
			'valid'			| 'disciplinesHandled'			| []
			'valid'			| 'disciplinesHandled'			| [new Staff()]
			
	}
	

}
