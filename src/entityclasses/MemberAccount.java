package entityclasses;

import java.io.*;
 
 /**
   * This class consists of member accounts, and ways to check and edit their statuses.
   * 
   * @author Alex Copley
   */
public class MemberAccount extends Account implements Serializable {
	
  private String status;
  
  /**
   * This function creates a MemberAccount entity using the user input strings.
   * 
   * @param name
   * @param number
   * @param address
   * @param city
   * @param zip
   * @param state
   */ 
  public MemberAccount(String name, String number, String address, String city, String zip, String state) {
	 
	  super(name, number, address, city, zip, state);
	  this.status = "Validated";
  
  }
  
  /**
   * This function checks the status of a MemberAccount, which will be either Validated or Invalid.
   * 
   * @return the status of the member
   */
  public String getStatus() {
	 
	  return this.status;
  
  }
  
  /**
   * This function changes the status of a MemberAccount, depending on what is inputed.
   * 
   */
  public void setStatus(String status) {
	 
	  this.status = status;
  
  }
  
}
