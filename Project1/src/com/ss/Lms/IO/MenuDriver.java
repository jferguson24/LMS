package com.ss.Lms.IO;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ss.Lms.model.Author;
import com.ss.Lms.model.Book;
import com.ss.Lms.model.Publisher;
import com.ss.Lms.service.LibrarianManager;

public class MenuDriver {
	private Integer input;
	private Scanner scan = new Scanner(System.in);
	private static Integer id = 100; 
	Author author;
	Publisher publisher;
	Book book;
	LibrarianManager service;
	Library library;
	public MenuDriver(){
		
	}
	
	public Integer getInput() throws InputMismatchException{
		scan = new Scanner(System.in);
		do {
			try {
				input = scan.nextInt();
			}catch (InputMismatchException e) 
			{
				System.out.println("Please only insert numbers");
				Library.welcomeMessage();
				input = getInput();
			}
			if(input < 1 || input > 4) {
				System.out.println("Incorrect Value\n"
					+ "Please enter correct value \n" ); 
			}
		}while(input < 1 || input > 4);
		//branch to exit method
		return input;
	}
	
	public Integer getDecision() {
		scan = new Scanner(System.in);
			do {
				try {
					input = scan.nextInt();
				}catch (InputMismatchException e) 
				{
					System.out.println("Please only insert numbers");
					Library.categoryMessage();
					input = getDecision();
				}
				scan.nextLine();
				if(input < 1 || input > 4) {
					System.out.println("Incorrect Value\n"
						+ "Please enter correct value \n" ); 
				}
			}while(input < 1 || input > 4);
		return input;
	}

	public void selectedChoice(String category, Integer userChoice ){
		String name, address, replacement, authorName, publisherName;
		
		if(category.compareTo("Author") == 0) 
		{
			id++;
			switch(userChoice){
				case 1:
					System.out.println("Enter the " + category + "'s name");
					name = scan.nextLine();
					
					System.out.println("Enter the address ");
					address = scan.nextLine();
					
					author = new Author(id,name,address);
					service = new LibrarianManager(category);
					service.addToList(author);
					break;
					
				case 2:
					System.out.println("Enter the name of the " + category
						+ " you wish to find");
					name = scan.nextLine();
					service = new LibrarianManager(category);
					service.find(name);
					break;
					
				case 3:
					System.out.println("Enter the name of the " + category
							+ " you wish to update");
					name = scan.nextLine();
					System.out.println("Re-enter or change " + category + "'s name");
					replacement = scan.nextLine();
					System.out.println("Enter the address ");
					address = scan.nextLine();
					service = new LibrarianManager(category);
					author = new Author(id,replacement,address);
					service.adjust(name, author);
					break;
				case 4:
					System.out.println("Enter the name of the " + category
							+ " you wish to delete");
					name = scan.nextLine();
					service = new LibrarianManager(category);
					service.delete(name);
					break;
			}
		}
		else if(category.compareTo("Book") == 0) {
			id++;
			switch(userChoice){
			case 1:
				System.out.println("Enter the " + category + "'s name");
				name = scan.nextLine();
				System.out.println("Enter the Publisher's ");
				publisherName = scan.nextLine();
				System.out.println("Enter the Author's name ");
				authorName = scan.nextLine();
				book = new Book(id, name, publisherName, authorName);
				service = new LibrarianManager(category);
				service.addToList(book);
				break;
				
			case 2:
				System.out.println("Enter the name of the " + category
					+ " you wish to find");
				name = scan.nextLine();
				service = new LibrarianManager(category);
				service.find(name);
				break;
			case 3:
				System.out.println("Enter the name of the " + category
						+ " you wish to update");
				name = scan.nextLine();
				System.out.println("Re-enter or change " + category + "'s name");
				replacement = scan.nextLine();
				System.out.println("Re-enter or change the the Author's name ");
				authorName = scan.nextLine();
				System.out.println("Re-enter or change the the Publisher's name ");
				publisherName = scan.nextLine();
				service = new LibrarianManager(category);
				book = new Book(id, replacement, publisherName, authorName);
				service.adjust(name, book);
				break;
			case 4:
				System.out.println("Enter the name of the " + category
						+ " you wish to delete");
				name = scan.nextLine();
				service = new LibrarianManager(category);
				service.delete(name);
				break;
			}
		}
		else if(category.compareTo("Publisher") == 0) 
		{
			
			switch(userChoice){
				case 1:
					id++;
					System.out.println("Enter the " + category + "'s name");
					name = scan.nextLine();
					
					System.out.println("Enter the address ");
					address = scan.nextLine();
					
					publisher = new Publisher(id,name,address);
					service = new LibrarianManager(category);
					service.addToList(publisher);
					break;
					
				case 2:
					System.out.println("Enter the name of the " + category
						+ " you wish to find");
					name = scan.nextLine();
					service = new LibrarianManager(category);
					service.find(name);
					break;
					
				case 3:
					System.out.println("Enter the name of the " + category
							+ " you wish to update");
					name = scan.nextLine();
					System.out.println("Re-enter or change " + category + "'s name");
					replacement = scan.nextLine();
					System.out.println("Enter the address ");
					address = scan.nextLine();
					service = new LibrarianManager(category);
					publisher = new Publisher(id, replacement, address);
					service.adjust(name, publisher);
					break;
				case 4:
					System.out.println("Enter the name of the " + category
							+ " you wish to delete");
					name = scan.nextLine();
					service = new LibrarianManager(category);
					service.delete(name);
					break;
			}
		}
	}
}

