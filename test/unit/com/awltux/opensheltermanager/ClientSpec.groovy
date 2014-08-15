package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.Admission;
import com.awltux.opensheltermanager.Client;
import com.awltux.opensheltermanager.ClientEthnicityEnum;
import com.awltux.opensheltermanager.Discipline;
import com.awltux.opensheltermanager.Interview;
import com.awltux.opensheltermanager.Referral;
import com.awltux.opensheltermanager.SexEnum;
import com.awltux.opensheltermanager.SupportAddress;
import com.awltux.opensheltermanager.SupportWorker;

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Client)
class ClientSpec extends ConstraintUnitHelperSpec {

    def setup() {
		// Mock the validation method
		mockForConstraintsTests(Client)
    }

    def cleanup() {
    }
	
	void "test Client.name constraints" ( error,  field,  val) {
		
		when: "we create a Client using field and value from fixture"
			def obj = new Client("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'name'			| null
			'nullable'		| 'name'			| ''
			'size'		    | 'name'			| getLongString(51)
			'valid'			| 'name'			| 'a'
			'valid'			| 'name'			| getLongString(50)
	}
	
	void "test Client.dateOfBirth constraints" ( error, field, val) {
		
		when: "we create a Client using field and value from fixture"
			def obj = new Client("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field					| val
			'nullable'		| 'dateOfBirth'			| null
			'validator'		| 'dateOfBirth'			| getDate(100000)
			'valid'			| 'dateOfBirth'			| getDate()
			'valid'			| 'dateOfBirth'			| getDate(-100000)
			
	}

    void "test Client.sex constraints" ( error,  field,  val) {
		
		when: "we create a Client using field and value from fixture"
			def obj = new Client("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'sex'			| null
			'valid'			| 'sex'			| SexEnum.FEMALE
			
    }

    void "test Client.supportWorker constraints" ( error,  field,  val) {
		
		when: "we create a Client using field and value from fixture"
			def obj = new Client("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'supportWorker'	| null
			'valid'			| 'supportWorker'	| new SupportWorker()
			
    }

    void "test Client.ethnicity constraints" ( error,  field,  val) {
		
		when: "we create a Client using field and value from fixture"
			def obj = new Client("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'ethnicity'			| null
			'valid'			| 'ethnicity'			| ClientEthnicityEnum.WHITE_UK
			
    }

    void "test Client.referrals constraints" ( error,  field,  val) {
		
		when: "we create a Client using field and value from fixture"
			def obj = new Client("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field			| val
			'nullable'		| 'referrals'	| null
			'client.referrals.isempty.error'		| 'referrals'	| []
			'valid'			| 'referrals'	| [new Referral()]
			
    }

    void "test Client.interviews constraints" ( error,  field,  val) {
		
		when: "we create a Client using field and value from fixture"
			def obj = new Client("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'interviews'			| null
			'valid'			| 'interviews'			| new Interview()
			
    }

    void "test Client.admissions constraints" ( error,  field,  val) {
		
		when: "we create a Client using field and value from fixture"
			def obj = new Client("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'admissions'			| null
			'valid'			| 'admissions'			| new Admission()
			
    }

    void "test Client.addresses constraints" ( error,  field,  val) {
		
		when: "we create a Client using field and value from fixture"
			def obj = new Client("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'addresses'			| null
			'valid'			| 'addresses'			| new SupportAddress()
			
    }

    void "test Client.disciplines constraints" ( error,  field,  val) {
		
		when: "we create a Client using field and value from fixture"
			def obj = new Client("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'disciplines'			| null
			'valid'			| 'disciplines'			| new Discipline()
			
    }

}
