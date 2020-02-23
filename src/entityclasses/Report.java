package entityclasses;

import java.io.*;
import java.util.ArrayList;

/**
 * The class that MemberReport and ProviderReport will
 * inherit
 * 
 * @author Zach McKerrow
 *
 */
public abstract class Report {
	
	private File reportFile;
	private ArrayList<ServiceRecord> weeklyServices;
	public abstract void generateReport() throws IOException;
	
	/**
	 * This function gets the weekly services saved to the report
	 * 
	 * @return the list of service from the week
	 */
	public ArrayList<ServiceRecord> getWeeklyServices() {
	
		return weeklyServices;
	
	}
	
	/**
	 * This function sets the service list used in the report
	 * 
	 * @param weeklyServices
	 */
	public void setWeeklyServices(ArrayList<ServiceRecord> weeklyServices) {
		
		this.weeklyServices = weeklyServices;
	
	}

	/**
	 * This function gets the file that the report is written to
	 * 
	 * @return report file
	 */
	public File getReportFile() {
		
		return reportFile;
	
	}

	/**
	 * This function sets the file that the report is written to
	 * 
	 * @param reportFile
	 */
	public void setReportFile(File reportFile) {
		
		this.reportFile = reportFile;
	
	}

}
