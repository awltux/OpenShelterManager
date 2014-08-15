package com.awltux.opensheltermanager


import com.awltux.opensheltermanager.ClientEthnicityEnum;
import com.awltux.opensheltermanager.SexEnum;
import org.joda.time.LocalDate
import org.grails.databinding.BindingFormat

class Client {
	String name
	@BindingFormat('yyyy/MM/dd')
	Date dateOfBirth
	SexEnum sex = SexEnum.MALE
	SupportWorker supportWorker
	
	BigDecimal rentOwed
	BigDecimal getRentOwed() {
		BigDecimal totalRent = 0
		admissions.each {
			totalRent = totalRent + it.totalOutstanding
		}
		return totalRent
	}
	
	ClientEthnicityEnum ethnicity = ClientEthnicityEnum.WHITE_UK
	
	// FIXME[with Grails 2.4.1]: To work around GRAILS-10727
	List<Referral> referrals = []
	List<Interview> interviews = []
	List<Admission> admissions = []
	List<SupportAddress> addresses = []
	List<Discipline> disciplines = []
	static hasMany = [
		referrals:Referral, 
		interviews:Interview,
		admissions:Admission,
		addresses:SupportAddress,
		disciplines:Discipline
	]
	
	
	public String toString() {
		return name + ' [' + ((Date)dateOfBirth)?.toString() + ']';
	}

	ClientStatusEnum status = ClientStatusEnum.INACTIVE
	static transients = ['rentOwed']
	
    static constraints = {
		id(display:false)
		
		// Required and must be 1 to 50 characters long
		name(blank:false, nullable:false, size:1..50)
		
		status(nullable:false)
		
		// DOB is required and must be in the past
		dateOfBirth(
			nullable:false, 
			validator: { val, obj ->
			     if (val > new Date()) return ['cannotBeBornInFuture']
	        }
		)
		
		// Sex must be present
		sex(nullable:false)
		
		// ethnicity must be present
		ethnicity(nullable:false)
		
		rentOwed(nullable:true, editable: false)

		supportWorker(nullable:true)
		
		referrals(nullable:true)
		
		// interviews collection must be initialised
		interviews(nullable:true)
		
		// admissions collection must be initialised
		admissions(nullable:true)
		
		// addresses collection must be initialised
		addresses(nullable:true)
		
		// disciplines collection must be initialised
		disciplines(nullable:true)

    }
}
