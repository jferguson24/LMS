package com.ss.Lms.model;

import java.io.Serializable;

public class Author implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4537582756028631880L;

	private Integer authorId;
	
	private String authorName, authorAddress;
	
	private String prompt;
	
	public Author(){
		
	}
	
	public Author(Integer authorId, String authorName, String authorAddress) {
		this.authorAddress = authorAddress;
		this.authorId = authorId;
		this.authorName = authorName;
	}
	/**
	 * @return the authorId
	 */
	public Integer getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	/**
	 * @return the authorAddress
	 */
	public String getAuthorAddress() {
		return authorAddress;
	}
	/**
	 * @param authorAddress the authorAddress to set
	 */
	public void setAuthorAddress(String authorAddress) {
		this.authorAddress = authorAddress;
	}
	
	public String toString() {
		this.prompt = "Id:" + authorId + " Author:" 
				+ authorName + " Address:" + authorAddress 
				+ "\n";
		return prompt;
		
	}

}
