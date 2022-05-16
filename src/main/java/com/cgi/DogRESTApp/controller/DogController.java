package com.cgi.DogRESTApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.DogRESTApp.exceptions.DogWithThisIDAlreadyExistsException;
import com.cgi.DogRESTApp.exceptions.DogWithThisIDDoesNotExistException;
import com.cgi.DogRESTApp.model.Dog;
import com.cgi.DogRESTApp.service.DogService;

@RestController
@RequestMapping("/api/v1")
public class DogController {
	
	@Autowired
	private DogService dogServ;
	
	@GetMapping(value = "/dogs")
	public ResponseEntity<List<Dog>> getDogsHandler(){
		ResponseEntity<List<Dog>> re;
		List<Dog> dogs = dogServ.getAllDogs();
		re = new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
		return re;
	}
	
	@PostMapping(value = "/dogs")
	public ResponseEntity<?> addDogHandler(@RequestBody Dog newDogToAdd){
		ResponseEntity<?> re;
		try {
			Dog newDog = dogServ.addNewDog(newDogToAdd);
			re = new ResponseEntity<Dog>(newDog, HttpStatus.CREATED);
		} catch(DogWithThisIDAlreadyExistsException e) {
			re = new ResponseEntity<String>("Duplicate Resource: dog with this ID exists!", HttpStatus.CONFLICT);
		}
		return re;
	}
	
	@GetMapping(value = "/dogs/{dogId}")
	public ResponseEntity<?> getDogHandler(@PathVariable("dogId") int id){
		ResponseEntity<?> re;
		try {
			Dog dog = dogServ.getDog(id);
			re = new ResponseEntity<Dog>(dog, HttpStatus.OK);
		} catch(DogWithThisIDDoesNotExistException e) {
			re = new ResponseEntity<String>("Dog with this ID does NOT exist!", HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
	@PutMapping(value = "/dogs/{dogId}")
	public ResponseEntity<?> updateDogHandler(@RequestBody Dog updatedDog){
		ResponseEntity<?> re;
		try {
			Dog dog = dogServ.updateDog(updatedDog);
			re = new ResponseEntity<Dog>(dog, HttpStatus.OK);
		} catch(DogWithThisIDDoesNotExistException e) {
			re = new ResponseEntity<String>("Dog with this ID does NOT exist!", HttpStatus.NOT_FOUND);
		}
		return re;
	}
	
	@DeleteMapping(value = "/dogs/{dogId}")
	public ResponseEntity<?> deleteDogHandler(@PathVariable("dogId") int id){
		ResponseEntity<?> re;
		try {
			dogServ.deleteDog(id);
			re = new ResponseEntity<String>("Dog Deleted", HttpStatus.OK);
		} catch(DogWithThisIDDoesNotExistException e) {
			re = new ResponseEntity<String>("Dog with this ID does NOT exist!", HttpStatus.NOT_FOUND);
		}
		return re;
	}

}
