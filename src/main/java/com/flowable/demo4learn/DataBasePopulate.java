package com.flowable.demo4learn;

import java.util.ArrayList;
import java.util.List;

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
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("0001", "kermit"));
		personList.add(new Person("0002", "Jon"));
		personRepository.saveAll(personList);
	}

}
