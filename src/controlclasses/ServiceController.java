package controlclasses;

import java.util.ArrayList;
import entityclasses.MemberAccount;
import entityclasses.ProviderAccount;
import entityclasses.Service;
import entityclasses.ServiceRecord;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class that serves as the control point for interaction with the ServiceRecord and Services classes
 * 
 * @author Will Drennan
 */
public class ServiceController{
	
	private ArrayList<ServiceRecord> weeklyServices;
	
	/**
	 * This function adds a given service record to the list of weekly service records 
	 * 
	 * @param ServiceRecord service instance of a service record
	 */
	public void addServiceToList(ServiceRecord service) {
	
		this.weeklyServices = getServices();
		
		if(this.weeklyServices == null) {
			this.weeklyServices = new ArrayList<ServiceRecord>();
		}
		
		this.weeklyServices.add(service);
		saveServices();
		return;
	
	}
	
	/**
	 * This function creates the actual service record and adds it to the list
	 * 
	 * @param MemberAccount member the member account associated with the record
	 * @param ProviderAccount provider the provider account associated with the record 
	 * @param String serviceDate date of service provided
	 * @param Service service the service to be associated with the record
	 * @param String comment comments with the record
	 */
	public void newRecord(MemberAccount member, ProviderAccount provider, String serviceDate, Service service, String comment) {
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		ServiceRecord record = new ServiceRecord(dtf.format(now), serviceDate, member, provider, service, comment);
		addServiceToList(record);
		return;
	
	}
	
	/**
	 * This function gets the weekly service records
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @return list of weekly services
	 */
	 public ArrayList<ServiceRecord> getServices() {
	
		 ArrayList<ServiceRecord> services = null;
		 
		 try {
			 FileInputStream fis = new FileInputStream("src" + File.separator + "databasefiles" + File.separator + "WeeklyServices.ser");
			 ObjectInputStream ois = new ObjectInputStream(fis);
		     services = ((ArrayList<ServiceRecord>) ois.readObject());
			 ois.close();
		 }
		 catch (FileNotFoundException f) {
		 }
		 catch (IOException e) {
		 }
		 catch (ClassNotFoundException c) {
		 }
		  
		 return services;
	 
	 }	
	 
	/**
	 * This function saves the service list to a file for future use.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	 public void saveServices() {
	
		 try {
		     FileOutputStream fos = new FileOutputStream("src" + File.separator + "databasefiles" + File.separator + "WeeklyServices.ser", false);
		     ObjectOutputStream oos = new ObjectOutputStream(fos);
		     oos.writeObject(this.weeklyServices);
		     oos.close();
		 }
		 
		 catch (FileNotFoundException f) {
		 }
		 catch (IOException e) {
		 }
	
	 }

}