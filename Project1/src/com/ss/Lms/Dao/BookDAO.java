package com.ss.Lms.Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ss.Lms.model.Author;
import com.ss.Lms.model.Book;
import com.ss.Lms.model.Publisher;

public class BookDAO implements CRUD<Book> {
	
	private List<Book> books = new ArrayList<>();
	private Book book;
	private Integer index, id;
	private String info, comma = ",";
	private File file = new File("./resources/BookDatabase");
	private AuthorDAO authors =  new AuthorDAO();
	private PublisherDAO publishers = new PublisherDAO();
	
	public BookDAO() throws IOException {
		
		FileInputStream inStream = new FileInputStream(file);
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inStream));
	
		while((info = bufferReader.readLine()) != null) {
			String[] input = info.split(comma);
			
			this.id = Integer.parseInt(input[0]);
			book = new Book(this.id,input[1],input[2],input[3]);
			books.add(book);
		}
		bufferReader.close();
	}
	

	@Override
	public boolean create(Book m) {
		// TODO Auto-generated method stub
			
		if(retrieve(m.getBookName())) {
			System.out.println(m.getBookName() + " is already in the database.");
			return false;
		}
		if(publishers.retrieve(m.getPublisherName())) {
			if(authors.retrieve(m.getAuthorName())){
				books.add(m);
				return true;
				}	
			else {
			System.out.println("Author was not found."
			 		+ "\nCreate the author first and add"
			 		+ "\nthe book with the new author name.");
			return false;
			}
		}
		else {
				 System.out.println("Publisher was not found."
				 		+ "\nCreate the publisher first then add"
				 		+ "\nthe book with the new publisher name.");
				 return false;
			}		
	}

	@Override
	public boolean retrieve(String name) {
		// TODO Auto-generated method stub
		this.index = 0;
		for(Book book: books) {
			if(name.equals(book.getBookName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(String name, Book newBook) {
		if(retrieve(name)) {
			if(authors.retrieve(newBook.getAuthorName())) {
				if(publishers.retrieve(newBook.getPublisherName())) {
					books.set(index, newBook);
					return true;
				}
				else {
					System.out.println(newBook.getPublisherName() + " name was not found"
					 		+ "in the system. \nEnsure the new publisher name"
					 		+ "is recorded before \nreplacing this publisher.");
					 return false;
				}
			}
			else {
				System.out.println(newBook.getAuthorName() + " name was not found"
				 		+ "in the system. \nEnsure the new author name"
				 		+ "is recorded before \nreplacing this author.");
				 return false;
			}
		}
		return false;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		if(books.isEmpty())
			return false;
		else if(retrieve(name)){
			books.remove(books.get(index));
			return true;
		}
		return false;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		books.forEach(item -> System.out.println(item));
	}
	
	public String toString()
	{
		String prompt = "";
		for(Book shelf : books) {
			prompt += shelf.getBookId() + "," + shelf.getBookName() 
			+ "," + shelf.getPublisherName() + "," + shelf.getAuthorName()
			+ "\n";
		}
		return prompt;
	}


	@Override
	public String display() {
		String prompt = "";
		
		prompt = "Id#:" + books.get(index).getBookId() + " Title:" 
				+ books.get(index).getBookName() + "\nAuthor:" 
				+ books.get(index).getAuthorName() + " Published by:"
				+ books.get(index).getPublisherName() + "\n";
		return prompt;
	}


	public boolean removeAuthor(String name) {
		// TODO Auto-generated method stub
		this.index = 0;
		List<Book> temp = new ArrayList<>();
		for(Book book: books) {
			if(name.compareTo(book.getAuthorName()) == 0) {
			}
			else {
			temp.add(book);
			}
		}
		books = temp;
		return false;
	}
	
	public void removePublisher(String name) {
		// TODO Auto-generated method stub
		this.index = 0;
		List<Book> temp = new ArrayList<>();
		for(Book book: books) {
			if(name.compareTo(book.getPublisherName()) == 0) {
			}
			else {
			temp.add(book);
			}
		}
		books = temp;
	}
	
	public void updateAuthors(String name,Author author) {
		List<Book> temp = new ArrayList<>();
		for(Book book: books) {
			if(name.compareTo(book.getAuthorName()) == 0) {
				book.setAuthorName(author.getAuthorName());
				temp.add(book);
			}
			else {
			temp.add(book);
			}
		}
		books = temp;
	}
	
	public void updatePublishers(String name,Publisher publisher) {
		List<Book> temp = new ArrayList<>();
		for(Book book: books) {
			if(name.compareTo(book.getPublisherName()) == 0) {
				book.setPublisherName(publisher.getPublisherName());
				temp.add(book);
			}
			else {
			temp.add(book);
			}
		}
		books = temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
