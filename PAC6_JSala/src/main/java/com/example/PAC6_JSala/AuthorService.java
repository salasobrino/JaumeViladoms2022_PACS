package com.example.PAC6_JSala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	
	@Autowired
	private ApplicationCommandRunner runner;
	
	
	public List<Author> findAll(){
		
		return runner.getAuthors();
		
	}
	
	public Author addAuthor(Author author) {
				
		runner.getAuthors().add(author);
		
		return author;
		 
		}
	
	public String deleteAuthorByName (String name) {
		
		int index = findAuthorByName(name);
		
		runner.getAuthors().remove(index);
		//authorRepo.delete(findAuthorByName(name));
			
		return "Author deleted";
		
	
	}
	
	public String deleteAuthor(int index) {
		
		runner.getAuthors().remove(index);
		
		return "Author has been deleted by index";
		
	}
	
	public int findAuthorByName(String name) {
		
		int index = -1;
		 for( Author author : this.runner.getAuthors()) {
			 
			 if(author.getName().equals(name)) {
				 
				 index = this.runner.getAuthors().indexOf(author);
				 
				return index;
			 } 	
		 }
		 
		 return index;
	}
	
	public int findAuthorById(int id) {
		int index = -1;
		for( Author author : this.runner.getAuthors()) {
			 
			 if(author.getId()==id) {
				 
				 index = this.runner.getAuthors().indexOf(author);
		
			 } 			  
		 }
		 
		 return index;
		
	}
	
	public Author getAuthorByIndex (int index) {
		
		Author author = runner.getAuthors().get(index);
		
		return author;
		
		
	}
	
	public Author replaceAuthor(int index, Author author) {
		// TODO Auto-generated method stub
		
		runner.authors.set(index, author);
	
		return author;
			
	}
	
		
	}
	
	
	


