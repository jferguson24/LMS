package com.ss.Lms.IO;

public class Library {
    static String category = "";
    static String exit = "";
    static Integer choice = 0;
	static MenuDriver selection = new MenuDriver();
	public static void main(String[] args) {
		do {
		welcomeMessage();
		choice = selection.getInput();
		if(choice != 4) {
			category = getCategory(choice);
			categoryMessage();
			choice = selection.getDecision();
			selection.selectedChoice(category, choice);
			choice = 0;
			}	
		}while(choice != 4);
		
		System.out.println("Thank you and \nhave a nice day!!! ");
	}
	
	public static void welcomeMessage()
	{
		
		String prompt = "\nWelcome to the Library Managment Software\n"
				+ "Select a number for a service\n" + "1: Author \n"
				+ "2: Book\n" + "3: Publisher\n" + "4: Quit\n";
		
		System.out.println(prompt);
	}
	
	public static String getCategory(Integer input)
	{
		String category;
		
		switch(input){
			case 1:
				category = "Author";
				break;
			case 2:
				category = "Book";
				break;
			case 3:
				category = "Publisher";
				break;
			default:
				category = "";
		}
		return category;
	}
	
	public static void categoryMessage() {
		String prompt = "\n1: Create " + category + "\n" + "2: Read " + category  
				+ "\n" + "3: Update "+ category + "\n" + "4: Delete "+ category + "\n";
		System.out.println(prompt);
		
	}
	
	
	
	
}