package com.ss.Lms.service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.ss.Lms.Dao.AuthorDAO;
import com.ss.Lms.Dao.BookDAO;
import com.ss.Lms.Dao.PublisherDAO;


public class Controller {
	
	public  BookDAO books;
	public  PublisherDAO publishers;
	public  AuthorDAO authors;
	
	public FileOutputStream outStream;
	public File file;
	
	public Controller() {
		
	}

	
	public AuthorDAO getAllAuthors(){
		try {
			authors = new AuthorDAO();
		} catch (IOException e) {
			System.out.println("Could not obtain authors from database");
			e.printStackTrace();
		}
		return authors;
	}
	
	public PublisherDAO getAllPublishers(){
		try {
			publishers = new PublisherDAO();
		} catch (IOException e) {
			System.out.println("Could not obtain publishers from database");
			e.printStackTrace();
		}
		return publishers;
	}
	
	public BookDAO getAllBooks(){
		try {
			books = new BookDAO();
		} catch (IOException e) {
			System.out.println("Could not obtain books from database");
			e.printStackTrace();
			
		}
		return books;
	}
	
	public void saveAuthorData(){
		
		outStream = null;
	    file = new File("./resources/AuthorData");
	    try {
	    	outStream = new FileOutputStream(file);

	    	if (!file.exists()) {
	    		file.createNewFile();
	    	}
	    	byte[] bytesConvert = authors.toString().getBytes();
	    	outStream.write(bytesConvert);
	    	outStream.flush();
	    	System.out.println("Database updated Successfully");
	    	} 
	    catch (IOException e) {
	    	System.out.println("Could not write authors to database");
	       	} 
	    finally	{
	    		try {
	    			if (outStream != null) {
	    			outStream.close();
	    			}
	          } 
		  catch (IOException e) {
		     System.out.println("Error while closing the Stream");
		  }
		
	    }
	}
	
	public void saveBookData() {
		outStream = null;
	    file = new File("./resources/BookDatabase");
	    try {
	    	outStream = new FileOutputStream(file);

	    	if (!file.exists()) {
	    		file.createNewFile();
	    	}
	    	byte[] bytesConvert = books.toString().getBytes();
	    	outStream.write(bytesConvert);
	    	outStream.flush();
	    	System.out.println("Database updated Successfully");
	    	} 
	    catch (IOException e) {
	    	System.out.println("Could not write publishers to database");
	       		} 
	    finally	{
	    		try {
	    			if (outStream != null) {
	    				outStream.close();
	    			}
	          } 
		  catch (IOException e) {
		     System.out.println("Error while closing the Stream");
		  }
		
	    }
	}
	
	public void savePublisherData() {
		outStream = null;
	     file = new File("./resources/PublisherData");
	    try {
	    	outStream = new FileOutputStream(file);

	    	if (!file.exists()) {
	    		file.createNewFile();
	    	}
	    	byte[] bytesConvert = publishers.toString().getBytes();
	    	outStream.write(bytesConvert);
	    	outStream.flush();
	    	System.out.println("Database updated Successfully");
	    	} 
	    catch (IOException e) {
	    	System.out.println("Could not write books to database");
	       	} 
	    finally	{
	    		try {
	    			if (outStream != null) {
	    				outStream.close();
	    			}
	    		} 
	    		catch (IOException e) {
	    			System.out.println("Error in closing the Stream");
		  }
		
	    }
	}
	 
	
}