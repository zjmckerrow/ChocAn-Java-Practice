package boundaryclasses;

import java.io.*;
import java.util.*;
import controlclasses.ServiceController;
import entityclasses.ProviderDirectory;
import entityclasses.Service;
import controlclasses.AccountController;
import controlclasses.ProviderDirectoryController;

/**
 * The Provider Terminal is in charge of verifying
 * a Provider, and allows for them to do one of three functions: 
 * validate members, request the provider directory, or bill ChocAn
 * 
 * @author Max Moling
 */
public class ProviderTerminal{
	
	private String providerNumber;
	
	/**
	 * This function polls the provider for all the necessary information to save the performed service
	 */
	public void billChocAn() {
	
		// creates a new account controller
		AccountController ac = new AccountController();
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		
		// asks the user to enter the member number 
		System.out.println("Please enter the member's number to continue." + System.lineSeparator());
		String memberNumber = " ";
		
		try {
			memberNumber = s.readLine();
		} 
		catch (IOException e5) {
			e5.printStackTrace();
		}
		
		// creates new string using the member number
		String validation = validateMember(memberNumber);
		if(validation.equals("Invalid Number") || validation.equals("Member Suspended")) {
			System.out.println(validation + ", returning to the Provider Menu..." + System.lineSeparator());
			return;
		}
		
		// user enters the date of which the service was provided
		System.out.println("Please enter the date the service was provided in the following format : MM-DD-YYYY " + System.lineSeparator());
		String dateOfService = " ";
		
		try {
			dateOfService = s.readLine();
		} 
		catch (IOException e4) {
			e4.printStackTrace();
		}
		
		// asks the user for the service code
		System.out.println("Please enter the service code : " + System.lineSeparator());
		String serviceCode = " ";
		
		try {
			serviceCode = s.readLine();
		} 
		catch (IOException e3) {
			e3.printStackTrace();
		}
		
		// makes the user a new provider directory and checks for validity
		ProviderDirectory prov = new ProviderDirectory();
		Service serv = prov.findService(serviceCode);
		
		if(serv == null) {
			System.out.println("Invalid service code. Returning to the Provider Menu...");
			return;
		}
		
		String serviceName = serv.getName();
		
		if(serviceName.length() > 20) {
			serviceName = serviceName.substring(0, 20);
		}
		
		// asks the user if the service code matches what the user wanted
		System.out.println("Is this the service you requested? Please enter YES or NO: " + System.lineSeparator());
		System.out.println("	" + serviceName + System.lineSeparator());
		String choice = " ";
		
		try {
			choice = s.readLine();
		} 
		catch (IOException e2) {
			e2.printStackTrace();
		}
		
		// yes option
		if(choice.equals("YES") || choice.equals("yes")) {
			System.out.println("Would you like to leave a comment? Please type 'YES' or 'NO'" + System.lineSeparator());
			String dec = " ";
			
			try {
				dec = s.readLine();
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}
			
			String comment = " ";
			
			if(dec.equals("YES") || dec.equals("yes")) {
				System.out.println("Enter your comment : " + System.lineSeparator());
				
				try {
					comment = s.readLine();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			
			}
			else {
				comment = null;
			}
			
			ServiceController sc = new ServiceController();
			sc.newRecord(ac.findMember(memberNumber), ac.findProvider(this.providerNumber), dateOfService, serv, comment);
			System.out.println("Fee : " + serv.getFee());
			System.out.println("Service Record created! Thank you for your service to our members!" + System.lineSeparator());
		}
		// no option
		else if(choice.equals("NO") || choice.equals("no")) {
			System.out.println("Returning to the Provider Menu..." + System.lineSeparator());
		}
		else {
			System.out.println("Invalid choice. Returning to the Provider Menu..." + System.lineSeparator());
		}
		
		return;
	
	}
	
	/**
	 * This function requests the provider directory from the database
	 */
	public void requestProviderDirectory() {
	
		ProviderDirectoryController pdc = new ProviderDirectoryController();
		System.out.println("Sending Provider Directory...");
		
		try {
			pdc.getProviderDirectory();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Provider Directory sent!" + System.lineSeparator());
		return;
	
	}
	
	/**
	 * This function checks to see if the member being checked is valid
	 * 
	 * @param memberNumber
	 * @return member status
	 */
	public String validateMember(String memberNumber) {
	
		AccountController ac = new AccountController();
	    return ac.validateMember(memberNumber);
	
	}
	
	/**
	 * This function check to see if the provider number entered is valid, then redirects to the menu
	 * 
	 * @return true, false, or quit
	 */
	public String login() {
	
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Hello Provider! Please enter your 9 digit Provider Number : ");
		System.out.println("Or type 'quit' to go back to the Chocoholics Anonymous log in menu!" + System.lineSeparator());
		String potential = " ";
		
		try {
			potential = s.readLine();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// asks the user if they wish to quit/ the quit option
		if (potential.equals("quit") || potential.equals("Quit")) {
			System.out.println("Returning to the Chocoholics Anonymous log in..." + System.lineSeparator());
			return "quit";
		}
		else {
			AccountController ac = new AccountController();
			if(ac.findProvider(potential) != null) {
				System.out.println("Welcome " + ac.findProvider(potential).getName() + "!");
				System.out.println("Sending you to the Provider Menu..." + System.lineSeparator());
				this.providerNumber = potential;
				return "true";
			}
			
			System.out.println("Invalid Provider Number, try again!" + System.lineSeparator());
			return "false";
		
		}
	
	}
	
	/**
	 * This function allows the provider to choose what they would like to do and then redirects to the necessary functions
	 * 
	 * @return the next state for the main menu
	 */
	public String menu() {
	
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		String state = "signin";
		boolean active = true;
		
		while(active) {
		
			switch (state) {
		
			case "signin":

				System.out.println("Welcome to the Provider Menu!");
				System.out.println("Please tell us what we can do for you : " + System.lineSeparator());
				System.out.println("	1.) Validate member" + System.lineSeparator());
				System.out.println("	2.) Send bill" + System.lineSeparator());
				System.out.println("	3.) Request Provider Directory" + System.lineSeparator());
				System.out.println("Please type in your choice or 'help' for assistance or 'quit' to exit." + System.lineSeparator());
				String choice = " ";
				
				try {
					choice = s.readLine();
				} 
				catch (IOException e3) {
					e3.printStackTrace();
				}
				
				// validate state
				if(choice.equals("1") || choice.equals("validate member") || choice.equals("Validate member") || choice.equals("Validate Member") || choice.equals("validate") || choice.equals("Validate")) {
					state = "validate";
				}
				// bill state
				if(choice.equals("2") || choice.equals("Send bill") || choice.equals("send bill") || choice.equals("Send Bill") || choice.equals("send") || choice.equals("bill")) {
					state = "bill";
				}
				// directory state
				if(choice.equals("3") || choice.equals("Request Provider Directory") || choice.equals("request provider directory") || choice.equals("Request provider directory") || choice.equals("request") || choice.equals("provider directory")) {
					state = "directory";
				}
				// help state
				if(choice.equals("help") || choice.equals("Help")) {
					state = "help";
				}
				// quit state
				if(choice.equals("quit") || choice.equals("Quit")) {
					state = "end";
				}
		
				break;
		
			case "validate":
			
				System.out.println("To validate a member, please enter the 9-digit member number : " + System.lineSeparator());
				String memberNumber = " ";
				
				try {
					memberNumber = s.readLine();
				} 
				catch (IOException e2) {
					e2.printStackTrace();
				}
				
				String validation = validateMember(memberNumber);
				System.out.println(validation + System.lineSeparator());
				state = "signin";
			
				break;
			
			case "bill":
			
				billChocAn();
				state = "signin";
			
				break;
			
			case "directory":
			
				requestProviderDirectory();
				state = "signin";
			
				break;
			
			case "help":
			
				System.out.println("To validate a member, type in '1', 'Validate member', 'validate member', 'Validate Member', or 'validate'!");
				System.out.println("To send your bill to Chocoholics Anonymous, type in '2', 'Send bill', 'Send Bill', 'send bill', 'send', or 'bill'!");
				System.out.println("To request a Provider Directory, type in '3', 'Request Provider Directory', 'request provider directory', 'Request provider directory', 'request', or 'provider directory'!");
				System.out.println("To exit the Provider Menu, type in 'quit' or 'Quit'!");
				System.out.println("To return to the Provider Menu, type any key!");
				
				try {
					String string = s.readLine();
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
