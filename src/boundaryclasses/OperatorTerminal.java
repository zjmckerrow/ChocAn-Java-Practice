package boundaryclasses;

import java.util.*;
import java.io.*;
import controlclasses.AccountController;
import entityclasses.*;

/**
 * The Operator Terminal is in charge of managing Providers and Members, and allows for them to do one of three functions: 
 * add, update, or remove a member/provider.
 * 
 * @author Carson Keenan
 */
public class OperatorTerminal {
	
	/**
	 * This function checks to see if the entered operator number is valid and send the operator to the menu
	 * 
	 * @return true, false, or quit
	 */
	public String login() {
		
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Hello Operator! Please enter your 9 digit Operator Number : ");
		System.out.println("Or type 'quit' to go back to the Chocoholics Anonymous log in menu!" + System.lineSeparator());
		String potential = " ";
		
		try {
			potential = s.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (potential.equals("quit") || potential.equals("Quit")) {
			System.out.println("Returning to the Chocoholics Anonymous log in..." + System.lineSeparator());
			return "quit";
		}
		else {
			AccountController ac = new AccountController();
			if (ac.findOperator(potential) != null) {
				System.out.println("Welcome!");
				System.out.println("Sending you to the Operator Menu..." + System.lineSeparator());
				return "true";
			}
			
			System.out.println("Invalid Operator Number, try again!" + System.lineSeparator());
			return "false";
		}
		
	}
	
	/**
	 * This function redirects to wherever the operator would like to go and do within the options given to them
	 * 
	 * @return the new state for the main menu
	 */
	public String menu() {
		
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		String state = "signin";
		AccountController ac = new AccountController();
		boolean active = true;
		
		while(active) {
			
			switch (state) {
		
			case "signin":
				System.out.println("Welcome to the Operator Menu!");
				System.out.println("Please tell us what we can do for you : " + System.lineSeparator());
				System.out.println("	1.) Manage Provider Account" + System.lineSeparator());
				System.out.println("	2.) Manage Member Account" + System.lineSeparator());
				System.out.println("Please type in your choice or 'help' for assistance or 'quit' to exit." + System.lineSeparator());
				String choice = " ";
				
				try {
					choice = s.readLine();
				} 
				catch (IOException e20) {
					e20.printStackTrace();
				}
			
				if(choice.equals("1") || choice.equals("Manage Provider Account") || choice.equals("Manage provider account") || choice.equals("Manage provider") || choice.equals("manage provider") || choice.equals("Manage Provider")) {
					state = "managep";
				}
				if(choice.equals("2") || choice.equals("Manage Member Account") || choice.equals("Manage member account") || choice.equals("Manage member") || choice.equals("manage member") || choice.equals("Manage Member")) {
					state = "managem";
				}
				if(choice.equals("help") || choice.equals("Help")) {
					state = "help";
				}
				if(choice.equals("quit") || choice.equals("Quit")) {
					state = "end";
				}
		
				break;
			
			case "managep":
				
				System.out.println("What would you like to do?" + System.lineSeparator());
				System.out.println("	1.) Add Provider Account" + System.lineSeparator());
				System.out.println("	2.) Update Provider Account" + System.lineSeparator());
				System.out.println("	3.) Delete Provider Account" + System.lineSeparator());
				System.out.println("Please type in your choice or 'quit' to return to the operator menu." + System.lineSeparator());
				choice = " ";
				
				try {
					choice = s.readLine();
				} catch (IOException e19) {
					e19.printStackTrace();
				}
			
				if(choice.equals("1") || choice.equals("Add Provider Account") || choice.equals("Add provider account") || choice.equals("Add Provider") || choice.equals("add provider") || choice.equals("Add provider") || choice.equals("add") || choice.equals("Add")) {
					state = "addp";
				}
				if(choice.equals("2") || choice.equals("Update Provider Account") || choice.equals("Update provider account") || choice.equals("Update Provider") || choice.equals("update provider") || choice.equals("Update provider") || choice.equals("update") || choice.equals("Update")) {
					state = "updatep";
				}
				if(choice.equals("3") || choice.equals("Delete Provider Account") || choice.equals("Delete provider account") || choice.equals("Delete Provider") || choice.equals("delete provider") || choice.equals("Delete provider") || choice.equals("delete") || choice.equals("Delete")) {
					state = "deletep";
				}
				if(choice.equals("quit") || choice.equals("Quit")) {
					state = "signin";
				}
			
				break;
			
			case "managem":
				
				System.out.println("What would you like to do?" + System.lineSeparator());
				System.out.println("	1.) Add Member Account" + System.lineSeparator());
				System.out.println("	2.) Update Member Account" + System.lineSeparator());
				System.out.println("	3.) Delete Member Account" + System.lineSeparator());
				System.out.println("Please type in your choice or 'quit' to return to the operator menu." + System.lineSeparator());
				String choice1 = " ";
				
				try {
					choice1 = s.readLine();
				} 
				catch (IOException e18) {
					e18.printStackTrace();
				}
			
				if(choice1.equals("1") || choice1.equals("Add Member Account") || choice1.equals("Add member account") || choice1.equals("Add Member") || choice1.equals("add member") || choice1.equals("Add member") || choice1.equals("add") || choice1.equals("Add")) {
					state = "addm";
				}
				if(choice1.equals("2") || choice1.equals("Update Member Account") || choice1.equals("Update member account") || choice1.equals("Update Member") || choice1.equals("update member") || choice1.equals("Update member") || choice1.equals("update") || choice1.equals("Update")) {
					state = "updatem";
				}
				if(choice1.equals("3") || choice1.equals("Delete Member Account") || choice1.equals("Delete member account") || choice1.equals("Delete Member") || choice1.equals("delete member") || choice1.equals("Delete member") || choice1.equals("delete") || choice1.equals("Delete")) {
					state = "deletem";
				}
				if(choice1.equals("quit") || choice1.equals("Quit")) {
					state = "signin";
				}
			
				break;
			
			
			case "addp":
				
				System.out.println("Enter the name of the new provider." + System.lineSeparator());
				String newPName = " ";
				
				try {
					newPName = s.readLine();
				} 
				catch (IOException e17) {
					e17.printStackTrace();
				}
				
				System.out.println("Enter the number of the new provider." + System.lineSeparator());
				String newPNumber = " ";
				
				try {
					newPNumber = s.readLine();
				} 
				catch (IOException e16) {
					e16.printStackTrace();
				}
				
				if(ac.findProvider(newPNumber) != null) {
					System.out.println("Number already in use." + System.lineSeparator());
					break;
				}
				
				if(newPNumber.length() != 9) {
					System.out.println("Number must have 9 digits." + System.lineSeparator());
					break;
				}
				
				System.out.println("Enter the address of the new provider." + System.lineSeparator());
				String newPAddress = " ";
				
				try {
					newPAddress = s.readLine();
				} 
				catch (IOException e15) {
					e15.printStackTrace();
				}
				
				System.out.println("Enter the city of the new provider." + System.lineSeparator());
				String newPCity = " ";
				
				try {
					newPCity = s.readLine();
				} 
				catch (IOException e14) {
					e14.printStackTrace();
				}
				
				System.out.println("Enter the state of the new provider." + System.lineSeparator());
				String newPState = " ";
				
				try {
					newPState = s.readLine();
				} 
				catch (IOException e13) {
					e13.printStackTrace();
				}
				
				System.out.println("Enter the zip code of the new provider." + System.lineSeparator());
				String newPZip = " ";
				
				try {
					newPZip = s.readLine();
				} 
				catch (IOException e12) {
					e12.printStackTrace();
				}
				
				System.out.println("Adding the new provider..." + System.lineSeparator());
				ac.addProvider(newPName, newPNumber, newPAddress, newPCity, newPZip, newPState);
				System.out.println("New provider added." + System.lineSeparator());
				state = "signin";
			
				break;
			
			case "updatep":
				
				System.out.println("Enter the number of the provider you would like to update." + System.lineSeparator());
				String pNumber = " ";
				
				try {
					pNumber = s.readLine();
				} 
				catch (IOException e11) {
					e11.printStackTrace();
				}
				
				if(ac.findProvider(pNumber) == null) {
					System.out.println("Provider not found." + System.lineSeparator());
					break;
				}
				else {
					System.out.println("Enter the field you would like to update." + System.lineSeparator());
					System.out.println("Choices are 'name', 'number', 'address', 'city', 'state', or 'zip'." + System.lineSeparator());
					String pUpdateField = " ";
					
					try {
						pUpdateField = s.readLine();
					} 
					catch (IOException e1) {
						e1.printStackTrace();
					}
					
					System.out.println("Enter the new " + pUpdateField + " for the provider." + System.lineSeparator());
					String newPData = " ";
					
					try {
						newPData = s.readLine();
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
					
					System.out.println("Updating the provider..." + System.lineSeparator());
					ac.updateProvider(pNumber, pUpdateField, newPData);
					System.out.println("Provider updated." + System.lineSeparator());
				}
				
				state = "signin";
			
				break;
			
			case "deletep":
				
				System.out.println("Enter the number of the provider you would like to delete." + System.lineSeparator());
				String pNumber1 = " ";
				
				try {
					pNumber1 = s.readLine();
				} 
				catch (IOException e10) {
					e10.printStackTrace();
				}
				
				if(ac.findProvider(pNumber1) == null) {
					System.out.println("Invalid provider number. Returning to Operator menu." + System.lineSeparator());
				}
				else {
					System.out.println("Deleting the provider..." + System.lineSeparator());
					ac.deleteProvider(pNumber1);
					System.out.println("Provider deleted." + System.lineSeparator());
				}
				
				state = "signin";
			
				break;
			
		
			case "addm":
				
				System.out.println("Enter the name of the new member." + System.lineSeparator());
				String newMName = " ";
				
				try {
					newMName = s.readLine();
				} 
				catch (IOException e9) {
					e9.printStackTrace();
				}
				
				System.out.println("Enter the number of the new member." + System.lineSeparator());
				String newMNumber = " ";
				
				try {
					newMNumber = s.readLine();
				} 
				catch (IOException e8) {
					e8.printStackTrace();
				}
				
				if(ac.findMember(newMNumber) != null) {
					System.out.println("Number already in use." + System.lineSeparator());
					break;
				}
				
				if(newMNumber.length() != 9) {
					System.out.println("Number must be 9 digits." + System.lineSeparator());
					break;
				}
				
				System.out.println("Enter the address of the new member." + System.lineSeparator());
				String newMAddress = " ";
				
				try {
					newMAddress = s.readLine();
				} 
				catch (IOException e7) {
					e7.printStackTrace();
				}
				
				System.out.println("Enter the city of the new member." + System.lineSeparator());
				String newMCity = " ";
				
				try {
					newMCity = s.readLine();
				} 
				catch (IOException e6) {
					e6.printStackTrace();
				}
				
				System.out.println("Enter the state of the new member." + System.lineSeparator());
				String newMState = " ";
				
				try {
					newMState = s.readLine();
				} 
				catch (IOException e5) {
					e5.printStackTrace();
				
				}
				
				System.out.println("Enter the zip code of the new member." + System.lineSeparator());
				String newMZip = " ";
				
				try {
					newMZip = s.readLine();
				} 
				catch (IOException e4) {
					e4.printStackTrace();
				}
				
				System.out.println("Adding the new member..." + System.lineSeparator());
				ac.addMember(newMName, newMNumber, newMAddress, newMCity, newMZip, newMState);
				System.out.println("New member added." + System.lineSeparator());
				state = "signin";
				
				break;
			
			case "updatem":
				
				System.out.println("Enter the number of the member you would like to update." + System.lineSeparator());
				String mNumber = " ";
				
				try {
					mNumber = s.readLine();
				} 
				catch (IOException e3) {
					e3.printStackTrace();
				}
				
				if(ac.findMember(mNumber) == null) {
					System.out.println("Member not found." + System.lineSeparator());
					break;
				}
				
				System.out.println("Enter the field you would like to update." + System.lineSeparator());
				System.out.println("Choices are 'name', 'number', 'address', 'city', 'state', or 'zip'." + System.lineSeparator());
				String mUpdateField = " ";
				
				try {
					mUpdateField = s.readLine();
				} 
				catch (IOException e3) {
					e3.printStackTrace();
				}
				
				System.out.println("Enter the new " + mUpdateField + " for the provider." + System.lineSeparator());
				String newMData = " ";
				
				try {
					newMData = s.readLine();
				} 
				catch (IOException e3) {
					e3.printStackTrace();
				}
				
				System.out.println("Updating the member..." + System.lineSeparator());
				ac.updateMember(mNumber, mUpdateField, newMData);
				System.out.println("Member updated." + System.lineSeparator());
				state = "signin";
			
				break;
			
			case "deletem":
				
				System.out.println("Enter the number of the member you would like to delete." + System.lineSeparator());
				String mNumber1 = " ";
				
				try {
					mNumber1 = s.readLine();
				} 
				catch (IOException e2) {
					e2.printStackTrace();
				}
				
				if(ac.findMember(mNumber1) == null) {
					System.out.println("Member not found." + System.lineSeparator());
					break;
				}
				
				System.out.println("Deleting the member..." + System.lineSeparator());
				ac.deleteMember(mNumber1);
				System.out.println("Member deleted." + System.lineSeparator());
				state = "signin";
			
				break;
				
			case "help":
			
				System.out.println("To manage a provider account, type in '1', 'Manage Provider', 'manage provider', 'Manage provider account', 'Manage Provider Account', or 'manage provider account'!");
				System.out.println("To manage a member account, type in '2', 'Manage Member', 'manage member', 'Manage member account', 'Manage Member Account', or 'manage member account'!");
				System.out.println("To exit the Operator Menu, type in 'quit' or 'Quit'!");
				System.out.println("To return to the Operator Menu, type any key!");
				
				try {
					s.readLine();
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				state = "signin";
			
				break;
			
			case "end":
			
				System.out.println("Would you like to : " + System.lineSeparator());
				System.out.println("	1.) Return to the Chocoholics Anonymous Sign-in?" + System.lineSeparator());
				System.out.println("	2.) Exit Chocoholics Anonymous Data Center?" + System.lineSeparator());
				String str = " ";
				
				try {
					str = s.readLine();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			
				if(str.equals("1")) {
					return "signin";
				}
				else if(str.equals("2")) {
					return "end";
				}
				else {
					System.out.println("Invalid choice, try again!" + System.lineSeparator());
				}
			
				break;
			
			default:
				
				state = "help";
			
				break;
			
			}
		
		}
		
	return "signin";
	
	}

}
