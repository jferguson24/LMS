package com.ss.Lms.model;

import java.io.Serializable;

public class Book implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3676530299739597023L;
	
	private Integer bookId;
	
	private String bookName, publisherName, authorName;
	
	private String prompt;
	
	Book(){
	}
	
	public Book(Integer bookId, String bookName, String publisherName, 
			String authorName){
		this.bookId = bookId;
		this.bookName = bookName;
		this.publisherName = publisherName;
		this.authorName = authorName;
	}

	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
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

	public String toString() {
		this.prompt =  "Id:" + bookId + " Title:" 
				+ bookName + " Published by:" + publisherName 
				+ " Written by:" + authorName + "\n";
		return prompt;
	}
	
}
