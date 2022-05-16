package com.cgi.DogRESTApp.service;

import java.util.List;

import com.cgi.DogRESTApp.exceptions.DogWithThisIDAlreadyExistsException;
import com.cgi.DogRESTApp.exceptions.DogWithThisIDDoesNotExistException;
import com.cgi.DogRESTApp.model.Dog;

public interface DogService {
	
	List<Dog> getAllDogs();
	Dog getDog(int id) throws DogWithThisIDDoesNotExistException;
	Dog addNewDog(Dog newDog) throws DogWithThisIDAlreadyExistsException;
	Dog updateDog(Dog updatedDog) throws DogWithThisIDDoesNotExistException;
	void deleteDog(int id) throws DogWithThisIDDoesNotExistException;

}
