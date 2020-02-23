package entityclasses;

import java.io.*;

/**
 * This class consists exclusively of provider accounts, as opposed to the MemberAccount class.
 * 
 * @author Alex Copley
 */
public class ProviderAccount extends Account implements Serializable {
  
	/**
	 * This function creates a ProviderAccount entity, using the user input strings.
	 * 
	 * @param name
	 * @param number
	 * @param address
	 * @param city
	 * @param zip
	 * @param state
	 */
	public ProviderAccount(String name, String number, String address, String city, String zip, String state) {
	
		super(name, number, address, city, zip, state);
    
	}
	
}
