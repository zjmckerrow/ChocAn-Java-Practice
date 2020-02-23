package controlclasses;

import java.io.*;
import java.util.*;
import entityclasses.*;

/**
* ProviderDirectoryController which takes care
* of the Provider Directory
* 
* @author Max Moling
*/
public class ProviderDirectoryController{
	
	/**
	 * This function writes the provider directory to a file in alphabetical order by service name
	 * 
	 * @throws IOException
	 */
	public void getProviderDirectory() throws IOException {
	
		ProviderDirectory pd = new ProviderDirectory();
		ArrayList<Service> services = pd.getServices();
		
		Collections.sort(services, new Comparator<Service>() {
			public int compare(Service s1, Service s2) {
				return s1.getName().compareToIgnoreCase(s2.getName());
			}
		});
		
		File directory = new File("release" + File.separator + "directory" + File.separator + "ProviderDirectory.txt");
		FileWriter fw = new FileWriter(directory, false);
		
		try {
			fw.write("Provider Directory : " + System.lineSeparator());
		
			for(int i=0; i < services.size(); i++) {
				Service service = services.get(i);
				fw.write(System.lineSeparator());
				fw.write("	Service Name : " + service.getName() + System.lineSeparator());
				fw.write("	Service Code : " + service.getCode() + System.lineSeparator());
				fw.write("	Service Fee  : " + service.getFee() + System.lineSeparator());
			}
		}
			
		catch(Exception ex) {
			System.out.println("Error writing Provider Directory to file.");
		}		

		fw.flush();
		fw.close();
	
	}

}