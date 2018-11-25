/*
 * Created by: University of Duisburg-Essen, paluno -The Ruhr Institute for Software Technology
 *
 * <p>For learning purpose only.
 *
 */
package com.oppahansi.ws1819.mp3;

public class Person {
	
	private Person leftSuccessor	= null;
	private Person rightSuccessor	= null;
	
	private String lastName;
	private String firstName;
	private int number;
	private boolean married;
	
	public Person(String lastName, String firstName, int number, boolean married){
		this.lastName	= lastName;
		this.firstName	= firstName;
		this.number		= number;
		this.married	= married;
	}

	public Person getLeftSuccessor() {
		return leftSuccessor;
	}

	public void setLeftSuccessor(Person leftSuccessor) {
		this.leftSuccessor = leftSuccessor;
	}

	public Person getRightSuccessor() {
		return rightSuccessor;
	}

	public void setRightSuccessor(Person rightSuccessor) {
		this.rightSuccessor = rightSuccessor;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}
	
	public String toString() {
		return "[" + lastName + ", " + firstName + ", " + number + ", " + married + "]";
	}

}
