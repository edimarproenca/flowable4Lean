package com.flowable.demo4learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.flowable.demo4learn.model.Person;
import com.flowable.demo4learn.repositories.PersonRepository;

@Component
public class DataBasePopulate implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		Person person = new Person("1234", "Kermit");
		personRepository.save(person);
	}

}
