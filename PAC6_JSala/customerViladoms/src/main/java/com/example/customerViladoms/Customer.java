package com.example.customerViladoms;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	
	@Id
	public String id;
	public String firstName;
	public String lastName;
	public int year;

	public Customer() {
	}

	public Customer(String id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	
	  public Customer(String id, String firstName, String lastName, int year) {
	  this.id = id; this.firstName = firstName; this.lastName = lastName; this.year
	  = year; }
	 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	  public int getYear() { return year; }
	  
	  public void setYear(int year) { this.year = year; }
	 

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", year=" + year + "]";
	}
	
	
}
