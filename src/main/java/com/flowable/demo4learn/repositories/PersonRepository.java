package com.flowable.demo4learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flowable.demo4learn.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	public boolean existsByName(String name);
	
}
