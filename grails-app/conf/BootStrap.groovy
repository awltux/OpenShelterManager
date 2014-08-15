import org.joda.time.LocalDate
import com.awltux.opensheltermanager.*

class BootStrap {

    def init = { servletContext ->
		Shelter shelterBathgate = new Shelter(
			name: 'Bathgate'
		).save()
		
		Staff staffBeeGood = new Staff(
			name:'Bee Good', 
			workPlace: shelterBathgate
		).save()
		
		Staff staffSugarLightly = new Staff(
			name:'Sugar Lightly', 
			workPlace: shelterBathgate
		).save()
		
		Staff staffTedBear = new Staff(
			name:'Ted Bear', 
			workPlace: shelterBathgate
		).save()
	
		Room room1 = new Room(
			name: 'room 1', 
			rentalRate: 6.00,
			description: 'This is a small room', 
			shelter: shelterBathgate
		).save()
		
		Room room2 = new Room(
			name: 'room 2', 
			rentalRate: 6.50,
			description: 'This is a medium room', 
			shelter: shelterBathgate
		).save()
		
		Room room3 = new Room(
			name: 'room 3', 
			rentalRate: 8.50,
			description: 'This is a small room with en-suite', 
			shelter: shelterBathgate
		).save()

		Room room4 = new Room(
			name: 'room 4', 
			rentalRate: 22.00,
			description: 'This is a small room with double bed', 
			shelter: shelterBathgate
		).save()
		
		ReferredBy reffererJoeBlogs = new ReferredBy(
			referralOrganisation: ReferralOrganisationEnum.HOUSING_OFFICER,
			contactName: 'Joe Bloggs'
		).save()
		
		ReferredBy reffererJackieSmith = new ReferredBy(
			referralOrganisation: ReferralOrganisationEnum.FAMILY,
			contactName: 'Jackie Smith'
		).save()
		
		Client clientAndyWarhol = new Client(
			name: 'Andy Warhol',
			dateOfBirth: new LocalDate()
		).save();
		
		Client clientWarrenBeaty = new Client(
			name: 'Warren Beaty',
			dateOfBirth: new LocalDate()
		).save();
		
	    SupportAddress supportAddress = new SupportAddress(
			address1: 'In A Land',
			postalTown: 'Far Far Away',
			postCode: 'EH41',
			client: clientWarrenBeaty
		).save()

	    VisitAgreement visitAgreement = new VisitAgreement(
			agreedMinutesDuration: 120,
			address: supportAddress
		).save()

    }
    def destroy = {
    }
}
