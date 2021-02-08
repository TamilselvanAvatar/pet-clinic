package com.admin.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.admin.model.Person;

public class FetchMapper implements RowMapper<Person> {


	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person p = new Person();
		p.setId(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setMobile(rs.getString(3));
		p.setPetBreed(rs.getString(4));
		p.setDate(rs.getString(5));
		p.setTime(rs.getString(6));
		return p;
	}

}
