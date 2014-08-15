package com.awltux.opensheltermanager

import grails.test.mixin.TestFor
import spock.lang.Specification

//FIXME: Added to work around GRAILS-10474
import grails.test.mixin.web.ControllerUnitTestMixin

import org.codehaus.groovy.grails.plugins.databinding.DataBindingGrailsPlugin

import com.awltux.opensheltermanager.Client;
import com.awltux.opensheltermanager.Discipline;
import com.awltux.opensheltermanager.DisciplineTypeEnum;
import com.awltux.opensheltermanager.IncidentTypeEnum;
import com.awltux.opensheltermanager.Staff;

@TestMixin(ControllerUnitTestMixin) 		
//END FIXME
@TestFor(Discipline)
class DisciplineSpec extends ConstraintUnitHelperSpec {

    def setup() {
		//FIXME: Added to work around GRAILS-10474
		defineBeans(new DataBindingGrailsPlugin().doWithSpring)
		//END FIXME
		// Mock the validation method
		mockForConstraintsTests(Discipline)
    }

    def cleanup() {
    }

	void "test Discipline.dateOccurred constraints" ( error,  field,  val) {
		
		when: "we create a Discipline using field and value from fixture"
			def obj = new Discipline("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'dateOccurred'			| null
			'discipline.dateOccurred.inFuture.error'			| 'dateOccurred'			| getDate(100000)
			'valid'			| 'dateOccurred'			| getDate(-100000)
	}
	
	void "test Discipline.incidentType constraints" ( error,  field,  val) {
		
		when: "we create a Discipline using field and value from fixture"
			def obj = new Discipline("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field						| val
			'nullable'		| 'incidentType'			| null
			'valid'			| 'incidentType'			| IncidentTypeEnum.OTHER
	}
	
	void "test Discipline.disciplineType constraints" ( error,  field,  val) {
		
		when: "we create a Discipline using field and value from fixture"
			def obj = new Discipline("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'disciplineType'			| null
			'valid'			| 'disciplineType'			| DisciplineTypeEnum.OTHER
	}
	
	void "test Discipline.notes constraints" ( error,  field,  val) {
		
		when: "we create a Discipline using field and value from fixture"
			def obj = new Discipline("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'notes'			| null
			'size'			| 'notes'			| getLongString(1001)
			'valid'			| 'notes'			| getLongString(1000)
			'valid'			| 'notes'			| getLongString(1)
	}
	
	void "GRAILS_BUG.test Discipline.notes.blank constraints" ( error,  field,  val) {
		
		when: "we create a Discipline using field and value from fixture"
			def obj = new Discipline("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture: FIXME: blank throws nullable"
			error			| field				| val
			'valid'		    | 'notes'			| ''
			
	}
	
	void "test Discipline.disciplinedBy constraints" ( error,  field,  val) {
		
		when: "we create a Discipline using field and value from fixture"
			def obj = new Discipline("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'disciplinedBy'			| null
			'valid'			| 'disciplinedBy'			| new Staff()
	}
	
	void "test Discipline.client constraints" ( error,  field,  val) {
		
		when: "we create a Discipline using field and value from fixture"
			def obj = new Discipline("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'client'			| null
			'valid'			| 'client'			| new Client()
	}
	
}
