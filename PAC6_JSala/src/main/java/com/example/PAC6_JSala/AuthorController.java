package com.example.PAC6_JSala;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AuthorController {
	
	@Autowired
	private AuthorService authorservice;
	
	
	@GetMapping("authors")
	public ResponseEntity<Iterable<Author>> getAllAuthors(){
		
		var headers = new HttpHeaders();
		headers.add("ResponseGet", "getAllAuthors executed");
		headers.add("version", "1.0 Api Rest Author Object");
		
		return ResponseEntity.accepted().headers(headers).body(authorservice.findAll());
		
	}
	
	@PostMapping(path="/addauthor", consumes = "application/json" )
	public ResponseEntity<Author> createAuthor( @RequestBody Author author) {
	
		Author authorSaved = authorservice.addAuthor(author);
		
		var headers = new HttpHeaders();
		headers.add("ResponseCreate", "createAuthor executed");
		headers.add("version", "1.0 Api Rest Author Object");
		headers.add("Executed Output", "author created");	
		
		return ResponseEntity.accepted().headers(headers).body(authorSaved);
		
	}
	
	@DeleteMapping("/deleteauthor/{name}")
	public ResponseEntity<Author> deleteAuthor(@PathVariable String name) {
		
		String responsedelete = "";
		int indexAuthor = authorservice.findAuthorByName(name);
		Author authortodelete = null;
		
		if (indexAuthor != -1) {
			authortodelete = authorservice.getAuthorByIndex(indexAuthor);
			authorservice.deleteAuthor(indexAuthor);
			
			responsedelete = responsedelete + "Author: " + name + "this author has been deleted"
					+ "index" + indexAuthor;
			
		} else {
			
			System.out.println("Book not found, not deleted");
			responsedelete = responsedelete + "Author: " + name + " this author has not been finded"
					+ "index" + indexAuthor;
		}
		
		var headers = new HttpHeaders();
		headers.add("ResponseDeleted", "deleteBook executed");
		headers.add("version", "1.0 Api Rest Author Object");
		headers.add("Executed Output", responsedelete);
		
	
		return ResponseEntity.accepted().headers(headers).body(authortodelete);
		
	}
	
	
	  @DeleteMapping("/deletebyid/{id}") 
	  public String deleteAuthorById(@PathVariable int id) {
	  
	  String responsedelete = ""; 
	  int indexAuthor = authorservice.findAuthorById(id);
	  
	  if (indexAuthor != 0) { 
		  authorservice.deleteAuthor(indexAuthor);
	  
		  responsedelete = responsedelete + "Author: " + id 
				  + "this author has been deleted" + "index" + indexAuthor;
	  
	  } else { 
		  responsedelete = responsedelete + "Author: " + id 
				  + " this author has not been finded" + "index" + indexAuthor; }
	  
	  return responsedelete;
	  
	  }
	 
	
	  @PostMapping("/replaceAuthor/{name}") 
	  public String updateAuthor (@PathVariable String name, @RequestBody Author authorFromRest) {
	  
	  String responseUpdate = "";
	  
	  responseUpdate += "author found"; Boolean update = false;
	  
	  int indexBook = authorservice.findAuthorByName(name);    //   .findBookByTitle(title); 
	  Author authorToUpdate =  authorservice.getAuthorByIndex(indexBook);   //getBookIndex(indexBook);
	  
	  if ( indexBook == 0) {
	  
	  responseUpdate = responseUpdate + "book not found";
	  
	  } else {	  
	  
	  
	  if(authorFromRest.getName() != null) { 
		  responseUpdate += " - autor name value updated: " + authorFromRest.getName() + "( old value: "
				  + authorToUpdate.getName() + ")"; 
		  
		  authorToUpdate.setName(authorFromRest.getName()); 
		  update = true;  
	  }
	  
	  if(authorFromRest.getDob() != 0) { 
		  responseUpdate += " - Dob value update: " + authorFromRest.getDob() + "( old value: " 
				  + authorToUpdate.getDob()+ ")";
		  
		  authorToUpdate.setDob( authorFromRest.getDob()); 
		  update = true;
	  }  
	  
	  if(authorFromRest.getQtyBooks() != 0) { 
		  responseUpdate += " - qtyBookks value update: " + authorFromRest.getQtyBooks() + "( old value: " 
				  + authorToUpdate.getQtyBooks()+ ")"; 
		  
		  authorToUpdate.setQtyBooks(authorFromRest.getQtyBooks());                    //setQtyBooks(authorFromRest.getQtyBooks()); 
		  update = true; 
	  }
	  
	  if(authorFromRest.getAlive() != false) 
		  responseUpdate += " - year value update: " + authorFromRest.getAlive() + "( old value: " 
				  + authorToUpdate.getAlive()+ ")";
		  
		  authorToUpdate.setAlive(authorFromRest.getAlive()); 
		  update = true; 
	  }
	  
	  
	  if(!update) responseUpdate +=
	  " - try to uypdate but any field updated - something wrong happened";
	  
	  
	  authorservice.replaceAuthor(indexBook, authorToUpdate);
	  
	  return responseUpdate;	  
	 	
	  }
	
}
