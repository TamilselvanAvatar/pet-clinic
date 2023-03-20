package com.admin.repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.admin.model.Person;

@Repository
public class PetServiceDaoImpl implements PetServiceDao {

	@Autowired
	JdbcTemplate jdbctemplate;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDateTime now = LocalDateTime.now();
	String sysdate = dtf.format(now);
	
	static final String INSERT_QUERY = "insert into bookings values(?,?,?,?,?,?)";
	static final String FETCH_ALL_QUERY = "select * from bookings";
	static final String FETCH_TODAY_QUERY="select * from bookings where a_date = ?";
	static final String FETCH_DATETIME_QUERY = "select * from bookings where a_date = ? and a_time = ?";

	@Override
	public boolean addappointment(Person person) {
		boolean done = false;
		try {
			int count = jdbctemplate.update(INSERT_QUERY, person.getId(), person.getName(), person.getMobile(),
					person.getPetBreed(), person.getDate(), person.getTime());
			if (count > 0) {
				done = true;
			}
		} catch (DuplicateKeyException e) {
			return false;
		}

		return done;
	}
	
	@Override
	public List<Person> checkappointment(Person person) {
		 return jdbctemplate.query(FETCH_DATETIME_QUERY,new FetchMapper(),person.getDate(),person.getTime());
	}

	@Override
	public List<Person> viewappointments() {
		return jdbctemplate.query(FETCH_ALL_QUERY, new PersonMapper());
	}

	@Override
	public List<Person> today() {

		return jdbctemplate.query(FETCH_TODAY_QUERY, new TodayMapper(),sysdate);
	}

	

}
