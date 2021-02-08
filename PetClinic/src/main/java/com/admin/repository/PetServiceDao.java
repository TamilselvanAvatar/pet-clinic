package com.admin.repository;

import java.util.List;

import com.admin.model.Person;

public interface PetServiceDao {

	boolean addappointment(Person person);

	List<Person> viewappointments();

	List<Person> today();

	List<Person> checkappointment(Person person);
}
