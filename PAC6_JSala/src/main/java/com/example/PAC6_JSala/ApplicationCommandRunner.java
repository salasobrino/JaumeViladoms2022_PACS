package com.example.PAC6_JSala;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCommandRunner implements CommandLineRunner {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	List<Author> authors = new ArrayList<Author>();
		
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("Welcome to the runner from commandLineRunner");
		
		String response =  addAuthors();
		logger.info("Creating authors..." + response);
		logger.info("Authors: " + authors);		
		
	}
	
	public List<Author> getAuthors () {
		return authors;
	}	
	
	public String addAuthors() {		
		
		Author author1 = new Author(1, "Jana", 9, 2012, true);
		Author author2 = new Author(2, "Oriol", 14, 2007, true);
		Author author3 = new Author(3, "Guillem", 16, 2005, true);
		Author author4 = new Author(4, "Marta", 45, 1975, true);
		
		authors.add(author1);
		authors.add(author2);
		authors.add(author3);
		authors.add(author4);
		
		return "Authors created";
				
		}	
	
}
