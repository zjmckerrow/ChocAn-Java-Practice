package entityclasses;

import java.io.*;
import java.time.format.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class contains the functions to build the manager summary report.
 * 
 * @author Zach McKerrow
 *
 */
public class ManagerSummaryReport extends Report {
	
	private File reportFile;
	private ArrayList<ProviderAccount> providers;
	private ArrayList<ServiceRecord> weeklyServices;
	
	/**
	 * This function is the constructor for the manager summary report.  It stores the array parameters and creates the file in which the report will be written.
	 * 
	 * @param provs
	 * @param services
	 */
	public ManagerSummaryReport(ArrayList<ProviderAccount> provs, ArrayList<ServiceRecord> services) {
		
		this.providers = provs;
		this.weeklyServices = services;
		LocalDate date = LocalDate.now(); //get the current date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		this.reportFile = new File("release" + File.separator + "reports" + File.separator + "manager" + File.separator + date.format(formatter) + ".txt"); //create the report file with thr current date
	
	}
	
	/**
	 * This function generates the actual manager summary report and stores it in the file created in the constructor.
	 */
	public void generateReport() throws IOException {
		
		FileWriter fileWriter = new FileWriter(reportFile);
		double totalFee = 0; //initialize the total fee
		int totalConsultations = 0; //initialize the total consultations
		int totalProviders = 0; //initialize the total providers
		
		try {		
			fileWriter.write("Providers To Be Paid :" + System.lineSeparator());
			
			for(int i = 0; i < providers.size(); i++) { //loop through the providers	
				ProviderAccount provider = providers.get(i); //get current provider
				double fee = 0; //intitialize individual total fee
				int consultations = 0; //initialize individual total consultations
				
				for(int j = 0; j < weeklyServices.size(); j++) { //loop through the services to check for the current provider
					ServiceRecord record = weeklyServices.get(j); //get current service
					
					if(provider.getNumber().equals(record.getProvider().getNumber())) { //check if current provider is on current service
						consultations += 1; //add to individual consultations
						fee += record.getService().getFee(); //add to individual fee
					}
				}
				
				if(consultations > 0) { //check if current provider did anything this week
					fileWriter.write(System.lineSeparator());
					fileWriter.write("	Provider Name : " + provider.getName() + System.lineSeparator());
					fileWriter.write("	Number of Consultations : " + consultations + System.lineSeparator());
					fileWriter.write("	Total Fee to be Paid : " + fee + System.lineSeparator());
					totalProviders += 1; //add to total providers
				}
				
				totalFee += fee; //add individual fee to total fee
				totalConsultations += consultations; //add individual consultations to total consultations	
			}
			
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Total Number of Providers to be Paid : " + totalProviders + System.lineSeparator());
			fileWriter.write("Total Number of Consultations : " + totalConsultations + System.lineSeparator());
			fileWriter.write("Overall Fee : " + totalFee);	
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		fileWriter.flush();
		fileWriter.close(); //close file
		
	}

}
