package com.cgi.DogRESTApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Owner {
	
	@Id
	private int transactionNo;
	private String name;
	
	@OneToOne(mappedBy = "owner")
	private Dog dog;

	public Owner(int transactionNo, String name) {
		super();
		this.transactionNo = transactionNo;
		this.name = name;
//		this.dog = dog;
	}
	
	public Owner() {}

	public int getTransactionNo() {return transactionNo;}
	public void setTransactionNo(int transactionNo) {this.transactionNo = transactionNo;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

//	public Dog getDog() {return dog;}
//	public void setDog(Dog dog) {this.dog = dog;}

	@Override
	public String toString() {
		return "Owner [transactionNo=" + transactionNo + ", name=" + name + ", dog=" + dog + "]";
	}

}
