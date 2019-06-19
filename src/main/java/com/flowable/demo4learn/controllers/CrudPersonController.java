package com.flowable.demo4learn.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.flowable.demo4learn.model.Person;
import com.flowable.demo4learn.repositories.PersonRepository;

@RestController
public class CrudPersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<Person> getEmployeeById (@PathVariable("id") Long id){
		Optional<Person> result = personRepository.findById(id);
		if(result.isPresent()) {
			return new ResponseEntity<Person>(result.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<Person>(new Person(), HttpStatus.NO_CONTENT);
		}
	}
	
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Person>> getAll(){
		return new ResponseEntity<List<Person>>(personRepository.findAll(), HttpStatus.OK);
	}
	
	
	
	
}
