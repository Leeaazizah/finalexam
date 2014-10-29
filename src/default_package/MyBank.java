package default_package;

import id.web.skyforce.bank.model.Address;
import id.web.skyforce.bank.model.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyBank {

	public static void main(String[] args) {
		
		
		
	}
	
	public static void saveDataCustomer() throws ParseException{
		
		String inputFirstName = ConsoleInput.read("- First Name : ");
		String inputLastName = ConsoleInput.read("- Last Name : ");
		String inputGender = ConsoleInput.read("- Gender : ");
		Date birthDate = new SimpleDateFormat("dd-MM-yy").parse(ConsoleInput
				.read("- Birth Date : "));
		String inputIdNumber = ConsoleInput.read("- Id Number : ");
		
		String inputCity = ConsoleInput.read("- City : ");
		String inputPostalCode = ConsoleInput.read("- Postal Code : ");
		String inputStreet = ConsoleInput.read("- Street : ");
		
		Customer customer = new Customer();
		
		customer.setFirstName(inputFirstName);
		customer.setLastName(inputLastName);
		customer.setGender(inputGender);
		customer.setBirthDate(birthDate);
		customer.setIdNumber(inputIdNumber);
		
		Address address = new Address();
		address.setCity(inputCity);
		address.setPostalCode(inputPostalCode);
		address.setStreet(inputStreet);
		
		customer.setAddress(address);
	}

}
