package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.Client;
import com.awltux.opensheltermanager.Interview;
import com.awltux.opensheltermanager.InterviewStatusEnum;
import com.awltux.opensheltermanager.Staff;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Interview)
class InterviewSpec extends ConstraintUnitHelperSpec {

    def setup() {
 		// Mock the validation method
		mockForConstraintsTests(Interview)
   }

    def cleanup() {
    }

	void "test Interview.date constraints" ( error,  field,  val) {
		
		when: "we create a Interview using field and value from fixture"
			def obj = new Interview("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'date'			| null
			'valid'			| 'date'			| getDate()
	}
	
	void "test Interview.interviewedBy constraints" ( error,  field,  val) {
		
		when: "we create a Interview using field and value from fixture"
			def obj = new Interview("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'interviewedBy'			| null
			'valid'			| 'interviewedBy'			| new Staff()
	}
	
	void "test Interview.notes constraints" ( error,  field,  val) {
		
		when: "we create a Interview using field and value from fixture"
			def obj = new Interview("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'notes'			| null
			'valid'			| 'notes'			| getLongString(1000)
			'maxSize'			| 'notes'			| getLongString(1001)
	}
	
	void "test Interview.status constraints" ( error,  field,  val) {
		
		when: "we create a Interview using field and value from fixture"
			def obj = new Interview("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'status'			| null
			'valid'			| 'status'			| InterviewStatusEnum.PLANNED
	}
	
	void "test Interview.client constraints" ( error,  field,  val) {
		
		when: "we create a Interview using field and value from fixture"
			def obj = new Interview("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'client'			| null
			'valid'			| 'client'			| new Client()
	}
	
}
