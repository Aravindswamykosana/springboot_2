package com.jsp.springboot_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_2.dao.EmployeeCrud;
import com.jsp.springboot_2.dto.Employee;
@RestController
public class EmployeeMain {
	@Autowired
	private EmployeeCrud crud;
	@PostMapping("/save")
	public Employee registerEmployee(@RequestBody Employee employee) {
		return crud.saveEmployee(employee);
	}
	
//	@GetMapping("/fetch")
	@PostMapping("/fetch")
	public Employee fetch(@RequestParam int id) {
		return crud.fetchEmployee(id);
	}
	
	@PostMapping("/alldata")
	public List<Employee> fetchAllEmp(@RequestBody List<Employee> emp){
		return crud.fetchAll(emp);
	}
}
