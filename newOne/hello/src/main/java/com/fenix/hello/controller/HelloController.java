package com.fenix.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String index() {
		return "hello";
	}
	
	@RequestMapping(value="/about")
	public String about() {
		String sql = "SELECT Name from sys_user WHERE Id = ?";
		String name= jdbcTemplate.queryForObject(sql, new Object[] {1},String.class);
		
		return "Hello"+name;
	}

}
