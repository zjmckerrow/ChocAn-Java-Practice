package entityclasses;

import java.io.*;
import java.time.format.*;
import java.time.LocalDate;
import java.util.*;

/**
 * This class contains the functions to build an EFT report and save it to a file.
 * 
 * @author Zach McKerrow
 *
 */
public class EFTReport extends Report {
	
	private File reportFile;
	private ArrayList<ProviderAccount> providers;
	private ArrayList<ServiceRecord> weeklyServices;
	
	/**
	 * This function is the constructor for the EFT report class.  It stores the passed in arrays and creates a file in which to write the report.
	 * 
	 * @param provs
	 * @param services
	 */
	public EFTReport(ArrayList<ProviderAccount> provs, ArrayList<ServiceRecord> services) {
	
		this.providers = provs;
		this.weeklyServices = services;
		LocalDate date = LocalDate.now(); //get the current time
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		this.reportFile = new File("release" + File.separator + "reports" + File.separator + "EFT" + File.separator + date.format(formatter) + ".txt");
	
	}
	
	/**
	 * This function generates the actual EFT report and stores it in the file created in the constructor.
	 */
	public void generateReport() throws IOException {
	
		FileWriter fileWriter = new FileWriter(reportFile);
		
		try {
			fileWriter.write("Providers and Funds to be Transferred :" + System.lineSeparator());
		
			for(int i = 0; i < providers.size(); i++) { //loop through the providers
				ProviderAccount provider = providers.get(i);
				double fee = 0;
				
				for(int j = 0; j < weeklyServices.size(); j++) { //loop through the services to check for the current provider
					ServiceRecord record = weeklyServices.get(j);
					if(provider.getNumber().equals(record.getProvider().getNumber())) {
						fee += record.getService().getFee();
					}
				}
				
				if(fee > 0) {
					fileWriter.write(System.lineSeparator());
					fileWriter.write("	Provider Name : " + provider.getName() + System.lineSeparator());
					fileWriter.write("	Provider Number : " + provider.getNumber() + System.lineSeparator());
					fileWriter.write("	Amount to be Transferred : " + fee + System.lineSeparator());
				}
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
		fileWriter.flush();
		fileWriter.close();
	
	}

}
