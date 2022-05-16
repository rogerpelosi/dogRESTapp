package com.cgi.DogRESTApp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.DogRESTApp.model.Dog;

@Repository
@Transactional
public interface DogRepository extends JpaRepository<Dog, Integer>{

}
