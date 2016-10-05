package com.crunchify.bean;

public class Employee {
	
	private String lastName;
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private String firstName;
	
	
	public Employee(String _lastName, String _firsname){
		lastName = _lastName;
		firstName = _firsname;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	

}
