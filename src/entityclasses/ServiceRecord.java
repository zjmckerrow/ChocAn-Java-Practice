package entityclasses;

import entityclasses.Service;
import java.io.*;
import java.time.LocalDateTime;

/**
 * This class contains all of the service record information the functions to build the service record
 * 
 * @author Will Drennan
 *
 */
public class ServiceRecord implements Serializable {
	
	private String currentDateAndTime;
	private String serviceDate;
	private MemberAccount member;
	private ProviderAccount provider;
	private Service service;
	private String comments;
	
	/**
	 * This function initializes the service record
	 *  
	 * @param String currentDate current date
	 * @param String servDate service date
	 * @param MemberAccount mem member account
	 * @param ProviderAccount prov	provider account
	 * @param Service serv service
	 * @param String comm comments
	 */
	public ServiceRecord(String currentDate, String servDate, MemberAccount mem, ProviderAccount prov, Service serv, String comm) {
	
		this.currentDateAndTime = currentDate;
		this.serviceDate = servDate;
		this.member = mem;
		this.provider = prov;
		this.service = serv;
		this.comments = comm;
		
	}
	
	/**
	 * This function gets the service saved in the record
	 * 
	 * @return service
	 */
	public Service getService() {
	
		return this.service;
	
	}
	
	/**
	 * This function gets the date that the record was received by the database
	 * 
	 * @return currentDateAndTime
	 */
	public String getTimeReceived() {
	
		return this.currentDateAndTime;
	
	}
	
	/**
	 * This function gets the date that the service was provided
	 * 
	 * @return service date
	 */
	public String getServiceDate() {
	
		return this.serviceDate;
	
	}
	
	/**
	 * This function returns the member on the record
	 * 
	 * @return memberAccount 
	 */
	public MemberAccount getMember() {
	
		return this.member;
	
	}
	
	/**
	 * This function returns the provider on the record
	 * 
	 * @return provider account
	 */
	public ProviderAccount getProvider() {
	
		return this.provider;
	
	}
	
	/**
	 * This function returns the comments on the record
	 * 
	 * @return comments 
	 */
	public String getComments() {
	
		return this.comments;
	
	}

}