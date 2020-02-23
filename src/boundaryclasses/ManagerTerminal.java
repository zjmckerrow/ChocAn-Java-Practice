package boundaryclasses;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import controlclasses.AccountController;
import controlclasses.ReportController;

/**
 * This class contains the functions for all the manager needs
 * 
 * @author Carson Keenan
 *
 */
public class ManagerTerminal {
	
	/**
	 * This function requests the generation of a certain member report
	 */
	public void requestMemberReport() {
		
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the 9 digit member number to generate a report." + System.lineSeparator());
		String number = " ";
		
		try {
			number = s.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AccountController ac = new AccountController();
		String memberStatus = ac.validateMember(number);
		
		if (memberStatus.contentEquals("Invalid member")) {
			System.out.println(memberStatus + System.lineSeparator());
			return;
		}
		else {
			ReportController rc = new ReportController();
			rc.generateMemberReport(number);
		}
		
		System.out.println("Member Report generated!");
		return;
		
	}
	
	/**
	 * This function requests the generation of a certain provider report
	 */
	public void requestProviderReport() {
		
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the 9 digit provider number to generate a report." + System.lineSeparator());
		String number = " ";
		
		try {
			number = s.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AccountController ac = new AccountController();
		
		if(ac.findProvider(number).equals(null)) {
			System.out.println("Invalid provider" + System.lineSeparator());
		}
		else {
			ReportController rc = new ReportController();
			rc.generateProviderReport(number);
		}
		
		System.out.println("Provider Report generated!");
		return;
		
	}
	
	/**
	 * This function requests the generation of one manager summary report
	 */
	public void requestManagerSummaryReport() {
		
		ReportController rc = new ReportController();
		rc.generateManagerSummaryReport();
		System.out.println("Manager Summary Report generated!");
		return;
		
	}
	
	/**
	 * This function check the managers number to log them in
	 * 
	 * @return true, false, quit
	 */
	public String login() {
		
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Hello Manager! Please enter your 9 digit Provider Number : ");
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
			if(ac.findManager(potential) != null) {
				System.out.println("Welcome!");
				System.out.println("Sending you to the Manager Menu..." + System.lineSeparator());
				return "true";
			}		
			System.out.println("Invalid Manager Number, try again!" + System.lineSeparator());
			return "false";
		}
		
	}
	
	/**
	 * This function redirects the manager to whatever is requested within their options
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

				System.out.println("Welcome to the Manager Menu!");
				System.out.println("Please tell us what we can do for you : " + System.lineSeparator());
				System.out.println("	1.) Request Member Report" + System.lineSeparator());
				System.out.println("	2.) Request Provider Report" + System.lineSeparator());
				System.out.println("	3.) Request Manager Summary Report" + System.lineSeparator());
				System.out.println("Please type in your choice or 'help' for assistance or 'quit' to exit." + System.lineSeparator());
				String choice = " ";
				
				try {
					choice = s.readLine();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
		
				if(choice.equals("1") || choice.equals("Request Member Report") || choice.equals("request member report") || choice.equals("Request member report") || choice.equals("Request member") || choice.equals("request member")) {
					state = "member_report";
				}
				if(choice.equals("2") || choice.equals("Request Provider Report") || choice.equals("request provider report") || choice.equals("Request provider report") || choice.equals("Request provider") || choice.equals("request provider")) {
					state = "provider_report";
				}
				if(choice.equals("3") || choice.equals("Request Manager Summary Report") || choice.equals("request manager summary report") || choice.equals("Request manager summary report") || choice.equals("request manager") || choice.equals("Request manager")) {
					state = "summary_report";
				}
				if(choice.equals("help") || choice.equals("Help")) {
					state = "help";
				}
				if(choice.equals("quit") || choice.equals("Quit")) {
					state = "end";
				}
				
				break;
		
			case "member_report":
			
				requestMemberReport();
				state = "signin";
			
				break;
			
			case "provider_report":
			
				requestProviderReport();
				state = "signin";
			
				break;
			
			case "summary_report":
			
				requestManagerSummaryReport();
				state = "signin";
			
				break;
			
			case "help":
			
				System.out.println("To request a member report, type in '1', 'Request member report', 'Request Member Report', 'request member report', 'Request member', or 'request member'!");
				System.out.println("To request a provider report, type in '2', 'Request provider report', 'Request Provider Report', 'request provider repoort', 'Request provider', or 'request provider'!");
				System.out.println("To request a manager summary report, type in '3', 'Request manager summary report', 'Request Manager Summary Report', 'request manager summary report', 'Request manager', or 'request manager'!");
				System.out.println("To exit the Provider Menu, type in 'quit' or 'Quit'!");
				System.out.println("To return to the Provider Menu, type any key!");
				
				try {
					s.readLine();
				} catch (IOException e1) {
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
				} catch (IOException e) {
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