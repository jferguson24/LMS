package com.ss.Lms.Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.ss.Lms.model.Publisher;

public class PublisherDAO implements CRUD <Publisher> {

	private List<Publisher> publishers = new ArrayList<>();
	private Publisher publisher;
	private Integer index, id;
	private String info, comma = ",";
	private File file = new File("./resources/PublisherData");
	
	public PublisherDAO() throws IOException {
		
		FileInputStream inStream = new FileInputStream(file);
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inStream));
	
		while((info = bufferReader.readLine()) != null) {
			String[] input = info.split(comma);
			
			this.id = Integer.parseInt(input[0]);
			publisher = new Publisher(this.id,input[1],input[2]);
			publishers.add(publisher);
		}
		bufferReader.close();
	}
	
	/* Create returns true when a new 
	 * publisher is created and added to the list
	 * returns false when item is present 
	 * */
	@Override
	public boolean create(Publisher m) {
		// TODO Auto-generated method stub
		
		if(publishers.isEmpty()) {
			publishers.add(m);
			return true;
		}
		else if(retrieve(m.getPublisherName())) {
			return false;
		}
		publishers.add(m);
		return true;
	}
	/* Retrieve returns true when publisher 
	 * is found then stores the index and
	 * returns false when publisher is not found 
	 * */
	@Override
	public boolean retrieve(String name) {
		// TODO Auto-generated method stub
		this.index = 0;
		for(Publisher publisher: publishers) {
			if(name.equals(publisher.getPublisherName())){
				return true;
			}
		}
		return false;
	}
	/*	Finds the publisher in which user wants change
	 * then replaces the information with new object
	 * */
	@Override
	public boolean update(String name, Publisher newPublisher) {
		if(publishers.isEmpty()) {
				return false;
		}
		else if(retrieve(name)) {
			publishers.set(index, newPublisher);
			return true;
		}
		return false;
	}
	/* Finds the name of the publisher and remove 
	 * it if found
	 * */

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		if(publishers.isEmpty()) {
			return false;
		}
		else if(retrieve(name)) {
			publishers.remove(publishers.get(index));
			return true;
		}
		return false;
	}
	/*
	 *To display all publishers currently stored in the list 
	 * */
	@Override
	public void printList() {
		// TODO Auto-generated method stub
		publishers.forEach(item -> System.out.println(item));
	}
	/*
	 * For writing data to the database in the correct format
	 * */
	public String toString()
	{
		String prompt = "";
		for(Publisher publisher : publishers) {
			prompt += publisher.getPublisherId() + "," + publisher.getPublisherName() 
			+ "," + publisher.getPublisherAddress() + "\n";
		}
		return prompt;
	}
	

	@Override
	public String display() {
		String prompt = "";
		
		prompt = "Id:" + publishers.get(index).getPublisherId() + " Publisher:" 
				+ publishers.get(index).getPublisherName() + " Address:" 
				+ publishers.get(index).getPublisherAddress() + "\n";
		return prompt;
	}
	
}
