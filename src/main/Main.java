package main;
import java.util.*;
import java.io.*;
import boundaryclasses.*;
import controlclasses.*;

/**
 * This is the main class for the program that redirects to the necessary menus for either the provider, manager, or the operator.
 * 
 * @author Zach McKerrow
 *
 */
public class Main {
	
	/**
	 * This is the main program for the program.  It creates the menu and redirects to the necessary menus.
	 */
	public static void main(String args[]) {
		
		BufferedReader s = new BufferedReader(new InputStreamReader (System.in));
		String state = "signin";
		boolean active = true;
		
		while(active) {	
			
			switch (state) {
			
			case "signin":
				System.out.println("Welcome to Chocoholics Anonymous!" + System.lineSeparator());
				System.out.println("Login as : " + System.lineSeparator());
				System.out.println("	1.) Provider" + System.lineSeparator());
				System.out.println("	2.) Manager" + System.lineSeparator());
				System.out.println("	3.) Operator" + System.lineSeparator());
				System.out.println("Or type 'help' for assistance!" + System.lineSeparator());
				String position = " ";
				
				try {
					position = s.readLine();
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
			
				if(position.equals("1") || position.equals("Provider") || position.equals("provider")) {
					state = "provider";
				}
				else if(position.equals("2") || position.equals("Manager") || position.equals("manager")) {
					state = "manager";
				}
				else if(position.equals("3") || position.equals("Operator") || position.equals("operator")) {
					state = "operator";
				}
				else if(position.equals("help") || position.equals("Help")) {
					state = "help";
				}
				else if(position.equals("end") || position.equals("End") || position.equals("quit") || position.equals("Quit")) {
					state = "end";
				}
				else if(position.equals("friday") || position.equals("Friday") || position.equals("f") || position.equals("F")) {
					state = "fridaymidnight";
				}
				else {
					System.out.println("Invalid input, try Again!");
				}
			
				break;
			
			case "provider":
			
				ProviderTerminal p = new ProviderTerminal();
				String login = p.login();
			
				if(login.equals("true")) {
					state = p.menu();
				}
				else if(login.equals("quit")) {
					state = "signin";
				}
				
				break;
				
			case "manager":
				
				ManagerTerminal m = new ManagerTerminal();
				String log = m.login();
			
				if(log.equals("true")) {
					state = m.menu();
				}
				else if(log.equals("quit")) {
					state = "signin";
				}
				
				break;
				
			case "operator":
				
				OperatorTerminal o = new OperatorTerminal();
				String l = o.login();
			
				if(l.equals("true")) {
					state = o.menu();
				}
				else if(l.equals("quit")) {
					state = "signin";
				}
				
				break;
				
			case "help":
				System.out.println("To login as a Provider, type '1', 'Provider' or 'provider'!");
				System.out.println("To login as a Manager, type '2', 'Manager' or 'manager'!");
				System.out.println("To login as an Operator, type '3', 'Operator' or 'operator'!");
				System.out.println("To end the session, type 'End' or 'end'!");
				System.out.println("To return to the login screen, type any key!");
				
				try {
					String placeholder = s.readLine();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				
				state = "signin";
			
				break;
				
			case "end":
				
				System.out.println("Thanks for visiting the Chocoholics Anonymous Data Center!");
				System.out.println("Come back again for all of your chocolate addiction needs!");
				return;
				
			case "fridaymidnight":
				
				System.out.println("Running main accounting procedure, one moment please..." + System.lineSeparator());
				ReportController rc = new ReportController();
				rc.runMainAccountingProcedure();
				state = "signin";
				
				break;
				
			default:
				
				state = "help";
			
				break;		
			}
		}
	
	}

}
