package com.cgi.DogRESTApp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Dog {
	
	@Id
	private int id;
	
	private String breed;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Owner owner;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getBreed() {return breed;}
	public void setBreed(String breed) {this.breed = breed;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public Owner getOwner() {return owner;}
	public void setOwner(Owner owner) {this.owner = owner;}
	
	public Dog(int id, String breed, String name, Owner owner) {
		super();
		this.id = id;
		this.breed = breed;
		this.name = name;
		this.owner = owner;
	}
	
	public Dog() {}
	
	@Override
	public String toString() {
		return "Dog [id=" + id + ", breed=" + breed + ", name=" + name + ", owner=" + owner + "]";
	}

}
