package entityclasses;

import java.io.*;
  
 /**
   * This class implements a generic account, and allows specific portions of an account to be accessed individually.
   * 
   * @author Alex Copley
   */
public abstract class Account implements Serializable {
 
  private String name;
  private String number;
  private String address;
  private String city;
  private String zipCode;
  private String state;
  
  /**
   * This function initializes the Account, using the inputed strings for each data member. 
   * 
   * @param name
   * @param number
   * @param address
   * @param city
   * @param zipCode
   * @param state
   */
  public Account(String name, String number, String address, String city, String zipCode, String state) {
	 
	  this.name = name;  //Sets the account's name based off of input.
	  this.number = number;  //Sets the account's user number based off of input.
	  this.address = address;  //Sets the account's user address based off of input.
	  this.city = city;  //Sets the account's city of residence based off of input.
	  this.zipCode = zipCode;  //Sets the account's local zip code based off of input.
	  this.state = state;  //Sets the account's state of residence based off of input.
  
  }
  
  /**
   * This function returns the name associated with the specific account. 
   * 
   * @return name on the account
   */
  public String getName() {
	 
	  return this.name;  //Returns the name associated with the account.
  
  }
  
  /**
   * This function changes the name associated with the account to the input string.
   * 
   * @param name
   */
  public void setName(String name) {
	  
	  this.name = name;  //Changes the name associated with the account to the input string.
  
  }
  
  /**
   * This function returns the number associated with the specific account. 
   * 
   * @return number on the account
   */
  public String getNumber() {
	 
	  return this.number;  //Returns the user number associated with the account.
  
  }
  
  /**
   * This function changes the number associated with the account to the input string.
   * 
   * @param number
   */
  public void setNumber(String number) {
	 
	  this.number = number;  //Changes the user number associated with the account to the input string.
  
  }
  
  /**
   * This function returns the address associated with the specific account. 
   * 
   * @return the address on the account
   */
  public String getAddress() {
	 
	  return this.address;  //Returns the user address associated with the account.
  
  }
  
  /**
   * This function changes the address associated with the account to the input string.
   * 
   * @param address
   */
  public void setAddress(String address) {
	 
	  this.address = address;  //Changes the address associated with the account to the input string.
  
  }
  
  /**
   * This function returns the city of residence associated with the specific account. 
   * 
   * @return the city on the account
   */
  public String getCity() {
	 
	  return this.city;  //Returns the city of residence associated with the account.
  
  }
  
  /**
   * This function changes the city associated with the account to the input string.
   * 
   * @param city
   */
  public void setCity(String city) {
	 
	  this.city = city;  //Changes the city of residence associated with the account to the input string.
  
  }
  
  /**
   * This function returns the zip code associated with the specific account. 
   * 
   * @return the zip code on the account
   */
  public String getZIPCode() {
	 
	  return this.zipCode;  //Returns the local zip code associated with the account.
  
  }
  
  /**
   * This function changes the zip code associated with the account to the input string.
   * 
   * @param zip
   */
  public void setZIPCode(String zip) {
	 
	  this.zipCode = zip;  //Changes the local zip code associated with the account to the input string.
  
  }
  
  /**
   * This function returns the state postal code associated with the specific account. 
   * 
   * @return the state on the account
   */
  public String getState() {
	  
	  return this.state;  //Returns the state postal code associated with the account.
  
  }
  
  /**
   * This function changes the state associated with the account to the input string.
   * 
   * @param state
   */
  public void setState(String state) {
	 
	  this.state = state;  //Changes the state associated with the account to the input string.
  
  }
  
}
