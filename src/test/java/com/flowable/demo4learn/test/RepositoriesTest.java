package com.flowable.demo4learn.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.constraints.AssertTrue;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flowable.demo4learn.model.Person;
import com.flowable.demo4learn.repositories.PersonRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoriesTest {

	
	
	@Autowired
	private PersonRepository personRepository;
	
	@Before
	public void clearData() {
		System.out.println("------- Cleaning Test Data -----------------");
		personRepository.deleteAllInBatch();
		System.out.println("------- Initiating    Test -----------------");
	}
	
	private List<Person> mockPersons() {
		List<Person> result = new ArrayList<Person>();
		result.add(new Person("001", "Kermit"));
		result.add(new Person("002", "Gonzo"));
		result.add(new Person("003", "Stalone"));
		result.add(new Person("004", "Neo"));
		return result;
	}
	
	/*
	 * This method save a List 
	 * @Param List<Person>
	 * */
	private List<Person> saveList(List<Person> toSave){
		List<Person> result = new ArrayList<Person>();
		try {
			System.out.println("Saving Data");
			result = personRepository.saveAll(toSave);
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error Insert Data");
		}
		return result;
	}
	
	private List<Person> findAllPersons() {
		List<Person> result = new ArrayList<Person>();
		try {
			System.out.println("Select Data...");
			result = personRepository.findAll();
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Error load Data");
		}
		
		if(result.size()>0) {
			result.stream().forEach(System.out::println);
		}else {
			System.out.println("Vazio");
		}
		return result;
	}
	
	@Test
	public void insertTest() {
		System.out.println("insertTest()");
		this.saveList(this.mockPersons());
		List<Person> fromDataBase = this.findAllPersons();
		
		fromDataBase.stream().forEach(person -> {
			System.out.println(person.toString());
		});
		Assert.assertTrue(fromDataBase.containsAll(this.mockPersons()));
	}	
	
	
	@Test
	public void deleteTest() {
		System.out.println("deleteTest()");
		this.saveList(this.mockPersons());
		if(this.findAllPersons().containsAll(this.mockPersons())) {
			System.out.println("Deleting..");
			personRepository.deleteAllInBatch();
			Assert.assertTrue(this.findAllPersons().size() == 0);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void findByNameTest() {
		System.out.println("findByNameTest");
		this.saveList(this.mockPersons());
		Assert.assertTrue(personRepository.existsByName("Kermit"));
	}
	
	
}
