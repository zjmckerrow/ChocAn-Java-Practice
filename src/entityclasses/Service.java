package entityclasses;

import java.io.*;

/**
 * Class that stores service names, fees, and codes with getters
 * 
 * @author Will Drennan
 */
public class Service implements Serializable {
	
	private String serviceName;
	private String serviceCode;
	private double serviceFee;
	
	/**
	 * This function initializes the service
	 * 
	 * @param name
	 * @param code
	 * @param fee
	 */
	public Service(String name, String code, double fee) {
	 
		this.serviceName = name;
		this.serviceCode = code;
		this.serviceFee = fee;
	
	}
	
	/**
	 * This function gets the name of the service
	 * 
	 * @return serviceName
	 */
	public String getName() {
		
		return this.serviceName;
	
	}
	
	/**
	 * This function gets the code for the service
	 * 
	 * @return serviceCode
	 */
	public String getCode() {
		
		return this.serviceCode;
	
	}
	
	/**
	 * This function gets the fee for the service
	 * 
	 * @return serviceFee
	 */
	public double getFee() {
	
		return this.serviceFee;
	
	}

}