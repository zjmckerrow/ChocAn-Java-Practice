package controlclasses;

import java.io.*;
import java.util.ArrayList;
import entityclasses.*;

/**
 * ReportController class contains the functions to generate
 * the reports and to Run the Main Accounting Procedure.
 * 
 * @author Carson Keenan
 *
 */
public class ReportController {
	
	/**
	 * This function generates the member report from their number.
	 * 
	 * @param memberNumber
	 */
	public void generateMemberReport(String memberNumber) {
	
		AccountController ac = new AccountController();
		ServiceController sc = new ServiceController();
		MemberAccount member = ac.findMember(memberNumber);
		MemberReport report = new MemberReport(member, sc.getServices());
		
		try {
			report.generateReport();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * This function generates the provider report from their number.
	 * 
	 * @param providerNumber
	 */
	public void generateProviderReport(String providerNumber) {
	
		AccountController ac = new AccountController();
		ServiceController sc = new ServiceController();
		ProviderAccount provider = ac.findProvider(providerNumber);
		ProviderReport report = new ProviderReport(provider, sc.getServices());
		
		try {
			report.generateReport();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * This function generates the manager summary report from the weekly services list.
	 */
	public void generateManagerSummaryReport() {
	
		AccountController ac = new AccountController();
		ServiceController sc = new ServiceController();
		ManagerSummaryReport report = new ManagerSummaryReport(ac.getProviders(), sc.getServices());
		
		try {
			report.generateReport();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * This function generates the EFT report from the weekly services file.
	 */
	public void generateEFTReport() {
	
		AccountController ac = new AccountController();
		ServiceController sc = new ServiceController();
		EFTReport report = new EFTReport(ac.getProviders(), sc.getServices());
		
		try {
			report.generateReport();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * This function generates all of the member and provider accounts, as well as a manager summary report and an EFT report.
	 */
	public void runMainAccountingProcedure() {
	
		AccountController ac = new AccountController();
		ServiceController sc = new ServiceController();
		
		for(int i = 0; i < ac.getMembers().size(); i++) {
			MemberAccount member = ac.getMembers().get(i);
			MemberReport report = new MemberReport(member, sc.getServices());
		
			try {
				report.generateReport();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(int j = 0; j < ac.getProviders().size(); j++) {
			
			ProviderAccount provider = ac.getProviders().get(j);
			ProviderReport report = new ProviderReport(provider, sc.getServices());
			
			try {
				report.generateReport();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		generateManagerSummaryReport();
		generateEFTReport();	
	
	}

}
