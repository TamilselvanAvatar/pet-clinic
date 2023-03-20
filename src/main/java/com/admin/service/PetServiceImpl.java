package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Person;
import com.admin.repository.PetServiceDao;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	PetServiceDao petservicedao;
	
	@Override
	public boolean addappointment(Person person) {
		return petservicedao.addappointment(person);
	}

	@Override
	public List<Person> viewappointments() {
		return petservicedao.viewappointments();
	}

	@Override
	public List<Person> today() {
		return petservicedao.today();
	}

	@Override
	public List<Person> checkappointment( Person person) {
		return petservicedao.checkappointment(person);
	}

}
