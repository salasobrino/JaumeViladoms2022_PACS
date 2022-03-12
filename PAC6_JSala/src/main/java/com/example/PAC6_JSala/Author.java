package com.example.PAC6_JSala;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "authors")
public class Author {
	
	@Id
	private int Id;
	public String name;
	public int dob;
	public int qtyBooks;
	public Boolean alive;
	
	public Author() {
		
	}	
	
	public Author( int Id, String name, int dob, int qtyBooks, Boolean alive) {
		super();
		this.Id=Id;
		this.name = name;
		this.dob = dob;
		this.qtyBooks = qtyBooks;
		this.alive = alive;
	}
	
	  public int getId() { return Id; }
	 
	
	  public void setId(int id) { Id = id; }
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public int getQtyBooks() {
		return qtyBooks;
	}

	public void setQtyBooks(int qtyBooks) {
		this.qtyBooks = qtyBooks;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "Author [Id=" + Id + ", name=" + name + ", dob=" + dob + ", qtyBooks=" + qtyBooks + ", alive=" + alive
				+ "]";
	}
	
	
	

}
