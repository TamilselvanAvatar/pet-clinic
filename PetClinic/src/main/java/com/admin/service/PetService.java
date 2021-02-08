package com.admin.service;

import java.util.List;

import com.admin.model.Person;

public interface PetService {

	boolean addappointment(Person person);
	
	List<Person> viewappointments();

	List<Person> today();

	List<Person> checkappointment( Person person);
}
