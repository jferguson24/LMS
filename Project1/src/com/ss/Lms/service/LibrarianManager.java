package com.ss.Lms.service;

import com.ss.Lms.model.Author;
import com.ss.Lms.model.Book;
import com.ss.Lms.model.Publisher;

public class LibrarianManager {

	private Controller control =  new Controller();
	private  String category;

	
	public LibrarianManager() {
	}
	public LibrarianManager(String category)
	{
		this.category = category;
	}
		
	public void addToList(Object holder) {
		if(category.compareTo("Author") == 0) {
			control.getAllAuthors();
			if(control.authors.create((Author) holder)) {
				System.out.println(category +" sucessfully added");
			}
			else {
				System.out.println("Author is already in the database");
			}
			control.saveAuthorData();
		}
		
		
		else if(category.compareTo("Book") == 0) {
			control.getAllBooks();
			if(control.books.create((Book) holder)){
				System.out.println(category + " sucessfully added");
			}
			control.saveBookData();;
		}
		
		
		else if(category.compareTo("Publisher") == 0) {
			control.getAllPublishers();
			if(control.publishers.create((Publisher) holder)) {
				System.out.println(category +" sucessfully added");
			}
			else {
				System.out.println(category + " is already in the database");
			}	
			control.savePublisherData();
		}
	}
	
	public void find(String name) {
		if(category.compareTo("Author") == 0) {
			control.getAllAuthors();
			if(control.authors.retrieve(name)) {
				System.out.println(control.authors.display());
			}
			else {
				System.out.println("Author not found");
			}
			
		}
		else if(category.compareTo("Publisher") == 0) {
			control.getAllPublishers();
			if(control.publishers.retrieve(name)) {
				System.out.println(control.publishers.display());
			}
			else {
				System.out.println(category + " not found");
			}
		}
		else if(category.compareTo("Book") == 0) {
			control.getAllBooks();	
			if(control.books.retrieve(name)) {
				System.out.println(control.books.display());
			}
			else {
				System.out.println(category + " not found");
			}
		}		
	}
	
	/*Selects the name from the list so that 
	 * */
	public void adjust(String name, Object holder) {
		if(category.compareTo("Author") == 0) {
			control.getAllAuthors();
			control.getAllBooks();
			if(control.authors.retrieve(name)) {
				control.authors.update(name, (Author) holder);
				control.books.updateAuthors(name, (Author) holder);
				System.out.println(control.authors.display());
			}
			else {
				System.out.println("Author not found");
			}
				control.saveAuthorData();
				control.saveBookData();
		}
		else if(category.compareTo("Publisher") == 0) {
			control.getAllPublishers();
			control.getAllBooks();
			if(control.publishers.retrieve(name)) {
				control.publishers.update(name, (Publisher) holder);
				control.books.updatePublishers(name, (Publisher) holder);
				System.out.println(control.publishers.display());
			}
			else {
				System.out.println(category + " not found");
			}
			control.savePublisherData();
			control.saveBookData();
		}	
		else if(category.compareTo("Book") == 0) {
			control.getAllBooks();
			if(control.books.retrieve(name)) {
				control.books.update(name, (Book) holder);
				System.out.println(control.books.display());
			}	
			control.saveBookData();
		}
	}
	/*Remove a name from the list
	 *Category ensure that the write list is being accesses
	 * */
	public void delete(String name) {
		if(category.compareTo("Author") == 0) {
			control.getAllAuthors();
			control.getAllBooks();
			if(control.authors.retrieve(name)) {
				control.authors.delete(name);
				control.books.removeAuthor(name);
				System.out.println( name + " is removed from database");
			}
			else {
				System.out.println("Author not found");
			}
			control.saveAuthorData();				
			control.saveBookData();
		}	
		else if(category.compareTo("Publisher") == 0) {
			control.getAllPublishers();
			control.getAllBooks();
			
			if(control.publishers.retrieve(name)) {
				control.publishers.delete(name);
				control.books.removePublisher(name);
				System.out.println( name + " is removed from database");
			}
			else {
				System.out.println(category + " not found");
			}
			control.savePublisherData();
			control.saveBookData();
		}
		else if(category.compareTo("Book") == 0) {
			control.getAllBooks();
			
			if(control.books.retrieve(name)) {
				control.books.delete(name);
				System.out.println( name + " is removed from database");
			}	
			control.saveBookData();
		}
	}
}
