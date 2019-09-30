package com.ss.Lms.model;

import java.io.Serializable;

public class Publisher implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4567263620112664435L;
	
	private Integer publisherId;
	
	private String publisherName; 

	private String publisherAddress;
	
	private String prompt;

	/**
	 * @return the publisherId
	 */
	
	public Publisher() {
		
	}
	
	public Publisher(Integer publisherId, String publisherName, 
			String publisherAddress) {
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
	}
	
	public Integer getPublisherId() {
		return publisherId;
	}

	/**
	 * @param publisherId the publisherId to set
	 */
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	/**
	 * @return the publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}

	/**
	 * @param publisherName the publisherName to set
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	/**
	 * @return the publisherAddress
	 */
	public String getPublisherAddress() {
		return publisherAddress;
	}

	/**
	 * @param publisherAddress the publisherAddress to set
	 */
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
	
	public String toString() {
		this.prompt = "Id:" + publisherId 
				+ " Author:" + publisherName + " Address:" +
				publisherAddress + "\n";
		return prompt;
		
	}
	
}
