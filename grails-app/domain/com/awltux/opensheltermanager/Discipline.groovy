package com.awltux.opensheltermanager

import com.awltux.opensheltermanager.DisciplineTypeEnum;
import com.awltux.opensheltermanager.IncidentTypeEnum;
import org.joda.time.LocalDate

class Discipline {
	LocalDate dateOccurred
	IncidentTypeEnum incidentType = IncidentTypeEnum.OTHER
	DisciplineTypeEnum disciplineType = DisciplineTypeEnum.OTHER
	String notes = ''
	
	Staff disciplinedBy
	Client client
	static belongsTo = [client:Client]
	
	public String toString() {
		return dateOccurred?.toString("yyyy/MM/dd") + ' [' + incidentType + ']';
	}

    static constraints = {
		id(display:false)
		
		client(nullable:false)
		disciplinedBy(nullable:false)
		dateOccurred(
			nullable:false,
			validator: { val, obj ->
				
			}
		)
		incidentType(nullable:false)
		disciplineType(nullable:false)
		notes(nullable:false, size:0..1000)
    }
	
	private validateDateOccurred(LocalDate dateOccurred, Discipline discipline){
		if(dateOccurred > new LocalDate()){
			return ['disciplineCannotBeInFuture']
		}
    }
}