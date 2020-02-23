package entityclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
* ProviderDirectory is in charge of containing the list of 
* services along with searching the list to find and get
* the service requested
* 
* @author Max Moling
*/
public class ProviderDirectory{
	
	private ArrayList<Service> directory;
	
	/**
	 * This function finds the service using the service code
	 * 
	 * @param serviceCode
	 * @return the service with the given number
	 */
	public Service findService(String serviceCode){
	
		this.directory = getServices();
		
		if(this.directory == null) {
			System.out.println("There are no services saved to the database.");
			return null;
		}
		
		for(int x=0; x < this.directory.size(); x++) {
			if(this.directory.get(x).getCode().equals(serviceCode)) {
				return this.directory.get(x);
			}
		}
		
		return null;
	
	}
	
	/**
	 * This function gets the list of services
	 * 
	 * @return the list of services
	 */
	public ArrayList<Service> getServices() {
	
		ArrayList<Service> services = null;
		
		try {
			 FileInputStream fis = new FileInputStream("src" + File.separator + "databasefiles" + File.separator + "Services.ser");
			 ObjectInputStream ois = new ObjectInputStream(fis);
		     services = ((ArrayList<Service>) ois.readObject());
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
	 * This function adds a new service to the list
	 * 
	 * @param serviceCode
	 * @param serviceName
	 * @param servicePrice
	 */
	public void addService(String serviceCode, String serviceName, double servicePrice) {
	
		if(findService(serviceCode) != null) {
			System.out.println("Service Code already in use.");
			return;
		}
		
		this.directory = getServices();
		
		if(this.directory == null) {
			this.directory = new ArrayList<Service>();
		}
		
		Service service = new Service(serviceName, serviceCode, servicePrice);
		directory.add(service);
		saveServices();
	
	}
	
	/**
	 * This function saves the list of services to a file for later
	 */
	public void saveServices() {
	
		try {
		     FileOutputStream fos = new FileOutputStream("src" + File.separator + "databasefiles" + File.separator + "Services.ser", false);
		     ObjectOutputStream oos = new ObjectOutputStream(fos);
		     oos.writeObject(this.directory);
		     oos.close();
		 }
		 catch (FileNotFoundException f) {
		 }
		 catch (IOException e) {
		 }
	
	}

}