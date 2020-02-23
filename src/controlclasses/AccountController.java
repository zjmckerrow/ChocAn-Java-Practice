package controlclasses;

import java.io.*;
import java.util.ArrayList;
import entityclasses.*;

/**
 * The Account Controller Class contains functions to
 * find specific members and providers, edit their accounts,
 * and validate their membership.
 * 
 * @author Alex Copley
 * 
 */
public class AccountController {
	
  private ArrayList<MemberAccount> memberAccounts;
  private ArrayList<ProviderAccount> providerAccounts;
  private ArrayList<String> managerNumbers;
  private ArrayList<String> operatorNumbers;
  
  
  /**
   * The findMember function searches for an individual member based off of their unique member number.
   * 
   * @param memberNumber
   * @return requested MemberAccount
   */
  public MemberAccount findMember(String memberNumber) {
	this.memberAccounts = getMembers();
	
	if(this.memberAccounts == null) {
		System.out.println("There are no members saved to the database.");
		return null;
	}
	
	for(int i=0; i < this.memberAccounts.size(); i++) {
		if(this.memberAccounts.get(i).getNumber().equals(memberNumber)) {
			return this.memberAccounts.get(i);
	}
  }
	
  return null;
  
  }
  
  /**
   * The findProvider function searches for an individual provider based off of their unique provider number.
   * 
   * @param providerNumber
   * @return requested ProviderAccount
   */
  public ProviderAccount findProvider(String providerNumber) {
	
	this.providerAccounts = getProviders();
	
	if(this.providerAccounts == null) {
		System.out.println("There are no providers saved to the database.");
		return null;
	}
	
	for(int i=0; i < this.providerAccounts.size(); i++) {
		if(this.providerAccounts.get(i).getNumber().equals(providerNumber)) {
			return this.providerAccounts.get(i);
		}
	}
	  
	return null;
  
  }
  
  /**
   * The findManager function searches for an individual manager based off of their unique manager number.
   * 
   * @param managerNumber
   * @return requested manager number
   */
  public String findManager(String managerNumber) {
	 
	  this.managerNumbers = getManagers();
	  
	  if(this.managerNumbers == null) {
		  System.out.println("There are no managers saved to the database.");
		  return null;
	  }
	  
	  for(int i=0; i < this.managerNumbers.size(); i++) {
		  if(this.managerNumbers.get(i).equals(managerNumber)) {
			  return this.managerNumbers.get(i);
		  }
	  }
	  
	  return null;
  
  }
  
  /**
   * The findOperator function searches for an individual operator based off of their unique provider number.
   * 
   * @param operatorNumber
   * @return requested operator number
   */
  public String findOperator(String operatorNumber) {
	 
	  this.operatorNumbers = getOperators();
	  
	  if(this.operatorNumbers == null) {
		  System.out.println("There are no operators saved to the database.");
		  return null;
	  }
	  
	  for(int i=0; i < this.operatorNumbers.size(); i++) {
		  if(this.operatorNumbers.get(i).equals(operatorNumber)) {
			  return this.operatorNumbers.get(i);
		  }
	  }
	  
	  return null;
  
  }
  
  /**
   * The addMember function creates a new MemberAccount, using input data from the user.
   * 
   * @param name
   * @param number
   * @param address
   * @param city
   * @param zip
   * @param state
   */
  public void addMember(String name, String number, String address, String city, String zip, String state) {
	 
	  MemberAccount member = findMember(number);
	  
	  if(member != null) {
		  System.out.println("Member is already in the database.");
		  return;
	  }
	  
	  member = new MemberAccount(name, number, address, city, zip, state);
	  this.memberAccounts = getMembers();
	  
	  if(this.memberAccounts == null) {
		  this.memberAccounts = new ArrayList<MemberAccount>();
	  }
	  
	  this.memberAccounts.add(member);
	  saveMembers();
  
  }
  
  /**
   * The addProvider function creates a new ProviderAccount, using input data from the user.
   * 
   * @param name
   * @param address
   * @param city
   * @param zip
   * @param state
   */
  public void addProvider(String name, String number, String address, String city, String zip, String state) {
	
	ProviderAccount provider = findProvider(number);
	
	if(provider != null) {
		System.out.println("Provider is already in the database.");
		return;
	}
	
	provider = new ProviderAccount(name, number, address, city, zip, state);
	this.providerAccounts = getProviders();
	
	if(this.providerAccounts == null) {
		this.providerAccounts = new ArrayList<ProviderAccount>();
	}
    
	this.providerAccounts.add(provider);
    saveProviders();
  
  }
  
  /**
   * The addManager function creates a new entry in the manager string array for the specific manager number added.
   * 
   * @param number
   */
  public void addManager(String number) {
	 
	  String manager = findManager(number);
	  
	  if(manager != null) {
		  System.out.println("Manager is already in the database.");
		  return;
	  }
	  
	  this.managerNumbers = getManagers();
	  
	  if(this.managerNumbers == null) {
		  this.managerNumbers = new ArrayList<String>();
	  }
	  
	  this.managerNumbers.add(number);
	  saveManagers();
  
  }
  
  /**
   * The addOperator function creates a new entry in the operator string array for the specific operator number added.
   * 
   * @param number
   */
  public void addOperator(String number) {
	 
	  String operator = findOperator(number);
	  
	  if(operator != null) {
		  System.out.println("Operator is already in the database.");
		  return;
	  }
	  
	  this.operatorNumbers = getOperators();
	  
	  if(this.operatorNumbers == null) {
		  this.operatorNumbers = new ArrayList<String>();
	  }
	  
	  this.operatorNumbers.add(number);
	  saveOperators();
  
  }
  
  /**
   * This function deletes the specified member, based off of their unique member number.
   * 
   * @param memberNumber
   */
  public void deleteMember(String memberNumber) {
	
	this.memberAccounts = getMembers();
	
	if(this.memberAccounts == null) {
		System.out.println("There are no members saved to the database.");
		return;
	}
	
	for(int i=0; i < this.memberAccounts.size(); i++) {
		if(this.memberAccounts.get(i).getNumber().equals(memberNumber)) {
			this.memberAccounts.remove(i);
		}
	}
	    
	saveMembers();
  
  }
  
  /**
   * This function deletes the specified provider, based off of their unique provider number.
   * 
   * @param providerNumber
   */
  public void deleteProvider(String providerNumber) {
	
	this.providerAccounts = getProviders();
	
	if(this.providerAccounts == null) {
		System.out.println("There are no providers saved to the database.");
		return;
	}
	
	for(int i=0; i < this.providerAccounts.size(); i++) {
		if(this.providerAccounts.get(i).getNumber().equals(providerNumber)) {
			this.providerAccounts.remove(i);
		}
	}
	    
	saveProviders();
  
  }
  
  /**
   * This function deletes the specified manager, based off of their unique manager number.
   * 
   * @param number
   */
  public void deleteManager(String number) {
	 
	  this.managerNumbers = getManagers();
	  
	  if(this.managerNumbers == null) {
		  System.out.println("There are no managers saved to the database.");
		  return;
	  }
	  
	  for(int i=0; i < this.managerNumbers.size(); i++) {
		  if(this.managerNumbers.get(i).equals(number)) {
			  this.managerNumbers.remove(i);
		  }
	  }
	 
	  saveManagers();
  
  }
  
  /**
   * This function deletes the specified operator, based off of their unique operator number.
   * 
   * @param number
   */
  public void deleteOperator(String number) {
	 
	  this.operatorNumbers = getOperators();
	  
	  if(this.operatorNumbers == null) {
		  System.out.println("There are no operators saved to the database.");
		  return;
	  }
	  
	  for(int i=0; i < this.operatorNumbers.size(); i++) {
		  if(this.operatorNumbers.get(i).equals(number)) {
			  this.operatorNumbers.remove(i);
		  }
	  }
	  
	  saveOperators();
  
  }
  
  /**
   * This function changes a specific portion of the indicated MemberAccount, using the unique member number to find the member,
   * and an update string to specify which part is being changed.
   * 
   * @param memberNumber
   * @param update
   * @param newString
   */
  public void updateMember(String memberNumber, String update, String newString) {
    
	MemberAccount member = findMember(memberNumber);
    
    if(member != null) {
    	if(update.equals("name")) {
    		member.setName(newString);
    	}
    	else if(update.equals("number")) {
    		member.setNumber(newString);
    	}
    	else if(update.equals("address")) {
    		member.setAddress(newString);
    	}
    	else if(update.equals("city")) {
    		member.setCity(newString);
    	}
    	else if(update.equals("zip")) {
    		member.setZIPCode(newString);
    	}
    	else if(update.equals("state")) {
    		member.setState(newString);
    	}
    	else {
    		System.out.println("Invalid update field.");
    		return;
    	}
    }
    
    saveMembers();
  
  }
  
  /**
   * This function changes a specific provider account, using the unique provider number of the specific provider 
   * and a update string to indicate the specific data being changed.
   * 
   * @param providerNumber
   * @param update
   * @param newString
   */
  public void updateProvider(String providerNumber, String update, String newString) {
	 
	  ProviderAccount provider = findProvider(providerNumber);
	  
	  if(provider != null) {
		  if(update.equals("name")) {
			  provider.setName(newString);
		  }
		  if(update.equals("number")) {
			  provider.setNumber(newString);
		  }
		  if(update.equals("address")) {
			  provider.setAddress(newString);
		  }
		  if(update.equals("city")) {
			  provider.setCity(newString);
		  }
		  if(update.equals("zip")) {
			  provider.setZIPCode(newString);
		  }
		  if(update.equals("state")) {
			  provider.setState(newString);
		  }
		  else {
			  System.out.println("Invalid update field.");
		  }
	 }
	  
	saveProviders();
  
  }
  
  /**
   * This function checks to see if an entered member number is a valid member, using the earlier findMember function.
   * 
   * @param memberNumber
   * @return member status
   */
  public String validateMember(String memberNumber) {
	 
	  if(findMember(memberNumber) == null) {
		  return "Invalid Number";
	  }
	  else {
		  return findMember(memberNumber).getStatus();
	  }
  
  }
  
  /**
   * This function returns all the providers in the database.
   * 
   * @return list of providers
   */
  public ArrayList<ProviderAccount> getProviders() {
	 
	  ArrayList<ProviderAccount> providerAccounts = null;
	  
	  try {
		  FileInputStream fis = new FileInputStream("src" + File.separator + "databasefiles" + File.separator + "Providers.ser");
		  ObjectInputStream ois = new ObjectInputStream(fis);
		  providerAccounts = ((ArrayList<ProviderAccount>) ois.readObject());
		  ois.close();
	  }
	  catch (FileNotFoundException f) {
	  }
	  catch (IOException e) {
	  }
	  catch (ClassNotFoundException c) {
	  }
	  
	  return providerAccounts;
  
  }
  
  /**
   * This function returns all the members in the database.
   * 
   * @return list of members
   */
  public ArrayList<MemberAccount> getMembers() {
	
	  ArrayList<MemberAccount> memberAccounts = null;
	  
	  try {
		  FileInputStream fis = new FileInputStream("src" + File.separator + "databasefiles" + File.separator + "Members.ser");
		  ObjectInputStream ois = new ObjectInputStream(fis);
		  memberAccounts = (ArrayList<MemberAccount>) ois.readObject();
		  ois.close();
	  }
	  catch (FileNotFoundException f) {
	  }
	  catch (IOException e) {
	  }
	  catch (ClassNotFoundException c) {
	  }
	  
	  return memberAccounts;
  
  }
  
  /**
   * This function returns all the managers in the database.
   * 
   * @return list of manager numbers
   */
  public ArrayList<String> getManagers() {	  
	  
	  ArrayList<String> managerNumbers = null;
	  
	  try {
		  FileInputStream fis = new FileInputStream("src" + File.separator + "databasefiles" + File.separator + "Managers.ser");
		  ObjectInputStream ois = new ObjectInputStream(fis);
		  managerNumbers = ((ArrayList<String>) ois.readObject());
		  ois.close();
	  }
	  catch (FileNotFoundException f) {
	  }
	  catch (IOException e) {
	  }
	  catch (ClassNotFoundException c) {
	  }
	  
	  return managerNumbers;
  
  }
  
  /**
   * This function returns all the operators in the database.
   * 
   * @return list of operator numbers
   */
  public ArrayList<String> getOperators() {
	 
	  ArrayList<String> operatorNumbers = null;
	  
	  try {
		  FileInputStream fis = new FileInputStream("src" + File.separator + "databasefiles" + File.separator + "Operators.ser");
		  ObjectInputStream ois = new ObjectInputStream(fis);
		  operatorNumbers = ((ArrayList<String>) ois.readObject());
		  ois.close();
	  }
	  catch (FileNotFoundException f) {
	  }
	  catch (IOException e) {
	  }
	  catch (ClassNotFoundException c) {
	  }
	  
	  return operatorNumbers;	  
  
  }
  
  /**
   * This function updates the members in the database.
   * 
   */  
  public void saveMembers() {
	 
	  try {
	      FileOutputStream fos = new FileOutputStream("src" + File.separator + "databasefiles" + File.separator + "Members.ser", false);
	      ObjectOutputStream oos = new ObjectOutputStream(fos);
	      oos.writeObject(this.memberAccounts);
	      oos.close();
	  }
	  catch (FileNotFoundException f) {
	  }
	  catch (IOException e) {
	  }
   
  }
  
  /**
   * This function updates the providers in the database.
   * 
   */
  public void saveProviders() {
	 
	  try {
	      FileOutputStream fos = new FileOutputStream("src" + File.separator + "databasefiles" + File.separator + "Providers.ser", false);
	      ObjectOutputStream oos = new ObjectOutputStream(fos);
	      oos.writeObject(this.providerAccounts);
	      oos.close();
	  }
	  catch (FileNotFoundException f) {
	  }
	  catch (IOException e) {
	  }
   
  }
  
  /**
   * This function updates the managers in the database.
   * 
   */
  public void saveManagers() {
	 
	  try {
	      FileOutputStream fos = new FileOutputStream("src" + File.separator + "databasefiles" + File.separator + "Managers.ser", false);
	      ObjectOutputStream oos = new ObjectOutputStream(fos);
	      oos.writeObject(this.managerNumbers);
	      oos.close();
	  }
	  catch (FileNotFoundException f) {
	  }
	  catch (IOException e) {
	  }
  
  }
  
  /**
   * This function updates the operators in the database.
   * 
   */
  public void saveOperators() {
	 
	  try {
	      FileOutputStream fos = new FileOutputStream("src" + File.separator + "databasefiles" + File.separator + "Operators.ser", false);
	      ObjectOutputStream oos = new ObjectOutputStream(fos);
	      oos.writeObject(this.operatorNumbers);
	      oos.close();
	  }
	  catch (FileNotFoundException f) {
	  }
	  catch (IOException e) {
	  }
  
  }

}