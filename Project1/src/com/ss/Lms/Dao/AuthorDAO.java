package com.ss.Lms.Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ss.Lms.model.Author;

public class AuthorDAO implements CRUD<Author> {
	
	private List<Author> authors =  new ArrayList<>();
	private Author author;
	private Integer index, id;
	private String info, comma = ",";
	private File file = new File("./resources/AuthorData");
	
	public AuthorDAO() throws IOException {
		
		FileInputStream inStream = new FileInputStream(file);
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inStream));
	
		while((info = bufferReader.readLine()) != null) {
			String[] input = info.split(comma);
			
			this.id = Integer.parseInt(input[0]);
			author = new Author(this.id, input[1], input[2]);
			authors.add(author);
		}
		
		bufferReader.close();
	}
	
	
	/* Create returns true when a new 
	 * author is created and added to the list
	 * returns false when item is present 
	 * */
	@Override
	public boolean create(Author author) {
		if(authors.isEmpty()) {
			authors.add(author);
			return true;
		}
		else if(retrieve(author.getAuthorName())) {
			return false;
		}
		authors.add(author);
		return true;
	}
	/* Retrieve returns true when author 
	 * is found then stores the index and
	 * returns false when author is not found 
	 * */
	@Override
	public boolean retrieve(String name) {
		this.index = 0;
		for(Author author: authors) {
			if(name.equals(author.getAuthorName())) { 
			return true;
			}
			index++;
		}
		return false;
		
	}
	/*
	 * 
	 * */
	@Override
	public boolean update(String name, Author newAuthor) {
		if(authors.isEmpty()) {
			return false;
		}
		else if(retrieve(name)) {
			authors.set(index, newAuthor);
			
			return true;
		}	
		return false;
	}

	@Override
	public boolean delete(String name) {
		if(authors.isEmpty()) {
			return false;
		}
		else if(retrieve(name))
		{
			
			authors.remove(authors.get(index));
			return true;
		}
		return false;
	}

	
	@Override
	public void printList() {
		authors.forEach(item -> System.out.println(item));	
	}
	
	public String display() {
		String prompt = "";
		
		prompt = "Id:" + authors.get(index).getAuthorId() + " Author:" 
				+ authors.get(index).getAuthorName() + " Address:" 
				+ authors.get(index).getAuthorAddress() + "\n";
		return prompt;

	}
	
	public String toString()
	{
		String prompt = "";
		for(Author author: authors) {
		prompt += author.getAuthorId() + "," + author.getAuthorName() 
			+ "," + author.getAuthorAddress() +"\n";
		}
		return prompt;
	}

	
	
	

	
}
