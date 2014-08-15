package com.awltux.opensheltermanager

import spock.lang.Specification

abstract class ConstraintUnitHelperSpec extends Specification {

	def setup() {
	}	
	
	Date getDate(Long timeSkew = 0){
		Date now = new Date( )
		Date dateToReturn = new Date(now.time + timeSkew )
		return dateToReturn
	}
	
    String getLongString(Integer length) {
       'a' * length
   }

   String getEmail(Boolean valid) {
       valid ? "dexter@miamipd.gov" : "dexterm@m"
   }

   String getUrl(Boolean valid) {
       valid ? "http://www.google.com" : "http:/ww.helloworld.com"
   }

   String getCreditCard(Boolean valid) {
       valid ? "4111111111111111" : "41014"
   }

   void validateConstraints( obj, field, error) {
       def validated = obj.validate()
       if (error && error != 'valid') {
           assert !validated
           assert null != obj.errors
           assert obj.errors[field]
           assert error == obj.errors[field]
       } 
	   else {
           assert !obj.errors[field]
       }
   }
}