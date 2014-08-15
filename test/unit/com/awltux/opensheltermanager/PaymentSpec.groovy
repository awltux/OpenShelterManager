package com.awltux.opensheltermanager

import grails.test.mixin.TestFor
import spock.lang.Specification

//FIXME: Added to work around GRAILS-10474
import grails.test.mixin.web.ControllerUnitTestMixin

import org.codehaus.groovy.grails.plugins.databinding.DataBindingGrailsPlugin

import com.awltux.opensheltermanager.Admission;
import com.awltux.opensheltermanager.Payment;
import com.awltux.opensheltermanager.Staff;
@TestMixin(ControllerUnitTestMixin)
//END FIXME
@TestFor(Payment)
class PaymentSpec extends ConstraintUnitHelperSpec {

    def setup() {
		//FIXME: Added to work around GRAILS-10474
		defineBeans(new DataBindingGrailsPlugin().doWithSpring)
		//END FIXME
 		// Mock the validation method
		mockForConstraintsTests(Payment)
    }

    def cleanup() {
    }
	
	void "test Payment.amount constraints" ( error,  field,  val) {
		
		when: "we create a Payment using field and value from fixture"
			def obj = new Payment("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'amount'			| null
			'min'			| 'amount'			| -0.1f
			'valid'			| 'amount'			| 0.0f
	}
	
	void "GRAILS_BUG.test Payment.amount.blank constraints" ( error,  field,  val) {
		
		when: "we create a Payment using field and value from fixture"
			def obj = new Payment("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture: FIXME: Blank throws nullable"
			error			| field				| val
			'blank'			| 'amount'			| ''
	}
	
	void "test Payment.received constraints" ( error,  field,  val) {
		
		when: "we create a Payment using field and value from fixture"
			def obj = new Payment("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'received'			| null
			'valid'			| 'received'			| new Date()
	}
	
	void "GRAILS_BUG.test Payment.received.blank constraints" ( error,  field,  val) {
		
		when: "we create a Payment using field and value from fixture"
			def obj = new Payment("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture: FIXME: Blank throws nullable"
			error			| field				| val
			'blank'			| 'received'			| ''
	}
	
	void "test Payment.receivedBy constraints" ( error,  field,  val) {
		
		when: "we create a Payment using field and value from fixture"
			def obj = new Payment("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'receivedBy'			| null
			'valid'			| 'receivedBy'			| new Staff()
	}

	void "test Payment.admission constraints" ( error,  field,  val) {
		
		when: "we create a Payment using field and value from fixture"
			def obj = new Payment("${field}": val )
			
		then: "Check validation of that field according to fixture"
			validateConstraints(obj, field, error)

		where: "we use this data fixture"
			error			| field				| val
			'nullable'		| 'admission'			| null
			'valid'			| 'admission'			| new Admission()
	}


}
