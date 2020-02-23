package entityclasses;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

/**
 * This class contains the functions to create the provider reports.
 * 
 * @author Zach McKerrow
 *
 */
public class ProviderReport extends Report {
	
	private File reportFile;
	private ProviderAccount provider;
	private ArrayList<ServiceRecord> weeklyServices;
	
	/**
	 * This function is the constructor for the provider report class.  It stores the array parameters and creates a file in which the report is written.
	 * 
	 * @param prov
	 */
	public ProviderReport(ProviderAccount prov, ArrayList<ServiceRecord> services) {
	
		this.provider = prov;
		this.weeklyServices = services;
		LocalDate date = LocalDate.now(); //get the current time
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		this.reportFile = new File("release" + File.separator + "reports" + File.separator + "provider" + File.separator + prov.getName() + date.format(formatter) + ".txt");		
	
	}

	/**
	 * This function generates the actual provider report and stores it in the file created in the constructor.
	 */
	public void generateReport() throws IOException {
	
		FileWriter fileWriter = new FileWriter(reportFile);
		double totalFee = 0;
		int consultations = 0;
		
		try {
			fileWriter.write("Provider Name : " + provider.getName() + System.lineSeparator());
			fileWriter.write("Provider Number : " + provider.getNumber() + System.lineSeparator());
			fileWriter.write("Provider Street Address : " + provider.getAddress() + System.lineSeparator());
			fileWriter.write("Provider City : " + provider.getCity() + System.lineSeparator());
			fileWriter.write("Provider State : " + provider.getState() + System.lineSeparator());
			fileWriter.write("Provider ZIP : " + provider.getZIPCode() + System.lineSeparator());
			fileWriter.write("Weekly Services Received :" + System.lineSeparator());
		
			for(int i = 0; i < weeklyServices.size(); i++) { //loop through the weekly services
				ServiceRecord record = weeklyServices.get(i);
				if(record.getProvider().getNumber().equals(provider.getNumber())) { //check for the current provider
					fileWriter.write(System.lineSeparator());
					fileWriter.write("	Date Of Service : " + record.getServiceDate() + System.lineSeparator());
					fileWriter.write("	Date and Time Received by the Computer : " + record.getTimeReceived() + System.lineSeparator());
					fileWriter.write("	Member Name : " + record.getMember().getName() + System.lineSeparator());
					fileWriter.write("	Member Number : " + record.getMember().getNumber() + System.lineSeparator());
					fileWriter.write("	Service Code : " + record.getService().getCode() + System.lineSeparator());
					fileWriter.write("	Fee To Be Paid : " + record.getService().getFee() + System.lineSeparator());
					totalFee += record.getService().getFee();
					consultations += 1;
				}
			}
			
			fileWriter.write(System.lineSeparator());
			fileWriter.write("Total Number Of Consultations : " + consultations + System.lineSeparator());
			fileWriter.write("Total Fee For Week : " + totalFee);
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	
		fileWriter.flush();
		fileWriter.close();
	
	}

}