package com.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.admin.model.Person;
import com.admin.service.PetService;

@Controller
public class AdminController {

	@Autowired
	PetService petservice;

	@GetMapping(value = "/index")
	public String index() {
		return "index";
	}

	@GetMapping(value = "/home")
	public String home(Model model) {
		model.addAttribute("person", new Person());
		return "home";
	}

	@PostMapping(value = "/booked")
	public String booked(@Valid @ModelAttribute("person") Person person, Model model) {

		if (petservice.checkappointment(person).isEmpty()) {
			if (petservice.addappointment(person))
				model.addAttribute("msg", "Appointment booking successful");
			else {
				model.addAttribute("msg", "Appointment not booked, duplicate ID");
			}
		} else {
			model.addAttribute("msg", "Appointment not booked, another appointment exist");
		}

		return "home";
	}

	@GetMapping(value = "/view")
	public String view(Model model) {
		List<Person> appointment = petservice.viewappointments();
		if(appointment.isEmpty()) {
			model.addAttribute("Empty","No appointments");
		}
		model.addAttribute("appointments", appointment);
		return "view";
	}

	@GetMapping(value = "/today")
	public String today(Model model) {
		List<Person> today = petservice.today();
		if (today.isEmpty()) {
			model.addAttribute("no_today", "No appointments today");
		} else
			model.addAttribute("today", today);
		return "today";
	}

}
