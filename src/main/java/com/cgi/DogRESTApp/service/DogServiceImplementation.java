package com.cgi.DogRESTApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.DogRESTApp.exceptions.DogWithThisIDAlreadyExistsException;
import com.cgi.DogRESTApp.exceptions.DogWithThisIDDoesNotExistException;
import com.cgi.DogRESTApp.model.Dog;
import com.cgi.DogRESTApp.repository.DogRepository;

@Service
public class DogServiceImplementation implements DogService {
	
	@Autowired
	private DogRepository dogRepo;

	@Override
	public List<Dog> getAllDogs() {
		return dogRepo.findAll();
	}

	@Override
	public Dog getDog(int id) throws DogWithThisIDDoesNotExistException {
		Optional<Dog> dogOptional = dogRepo.findById(id);
		if(dogOptional.isPresent()) {
			return dogOptional.get();
		}
		throw new DogWithThisIDDoesNotExistException();
	}

	@Override
	public Dog addNewDog(Dog newDog) throws DogWithThisIDAlreadyExistsException {
		Optional<Dog> dogOptional = dogRepo.findById(newDog.getId());
		if(dogOptional.isEmpty()) {
			dogRepo.save(newDog);
			return newDog;
		}
		throw new DogWithThisIDAlreadyExistsException();
	}

	@Override
	public Dog updateDog(Dog updatedDog) throws DogWithThisIDDoesNotExistException {
		Optional<Dog> dogOptional = dogRepo.findById(updatedDog.getId());
		if(dogOptional.isPresent()) {
//			dogOptional.get().setBreed(updatedDog.getBreed());
//			dogOptional.get().setName(updatedDog.getName());
//			dogRepo.save(dogOptional.get());
			dogRepo.save(updatedDog);
			return dogOptional.get();
		}
		throw new DogWithThisIDDoesNotExistException();
	}

	@Override
	public void deleteDog(int id) throws DogWithThisIDDoesNotExistException {
		Optional<Dog> dogOptional = dogRepo.findById(id);
		if(dogOptional.isPresent()) {
			dogRepo.delete(dogOptional.get());
		}
		throw new DogWithThisIDDoesNotExistException();
	}

}
