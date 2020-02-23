package entityclasses;

import java.io.*;
import java.time.format.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class contains the functions to create the member reports.
 * 
 * @author Zach McKerrow
 *
 */
public class MemberReport extends Report {
	
	private MemberAccount member;
	private File reportFile;
	private ArrayList<ServiceRecord> weeklyServices;
	
	/**
	 * This function is the constructor for the member report class.  It stores the array parameters and creates a file in which the report is written.
	 * 
	 * @param mem
	 * @param services
	 */
	public MemberReport(MemberAccount mem, ArrayList<ServiceRecord> services) {
	
		this.member = mem;
		this.weeklyServices = services;
		LocalDate date = LocalDate.now(); //get the current date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		this.reportFile = new File("release" + File.separator + "reports" + File.separator + "member" + File.separator + mem.getName() + date.format(formatter) + ".txt");		
	
	}

	/**
	 * This function generates the actual member report and stores it in the file created in the constructor.
	 */
	public void generateReport() throws IOException {
	
		FileWriter fileWriter = new FileWriter(reportFile);
		
		try {
			fileWriter.write("Member Name : " + member.getName() + System.lineSeparator());
			fileWriter.write("Member Number : " + member.getNumber() + System.lineSeparator());
			fileWriter.write("Member Street Address : " + member.getAddress() + System.lineSeparator());
			fileWriter.write("Member City : " + member.getCity() + System.lineSeparator());
			fileWriter.write("Member State : " + member.getState() + System.lineSeparator());
			fileWriter.write("Member ZIP : " + member.getZIPCode() + System.lineSeparator());
			fileWriter.write("Weekly Services Received :" + System.lineSeparator());
		
			for(int i = 0; i < weeklyServices.size(); i++) { //lopp through the weekly services
				ServiceRecord record = weeklyServices.get(i);
				if(record.getMember().getNumber().equals(member.getNumber())) { //check for the current member
					fileWriter.write(System.lineSeparator());
					fileWriter.write("	Date Of Service : " + record.getServiceDate() + System.lineSeparator());
					fileWriter.write("	Provider Name : " + record.getProvider().getName() + System.lineSeparator());
					fileWriter.write("	Service Name : " + record.getService().getName() + System.lineSeparator());
				}
			}
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		
		fileWriter.flush();
		fileWriter.close();
	
	}

}
