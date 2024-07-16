package com.jsp.springboot_2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_2.dto.Employee;
import com.jsp.springboot_2.repo.EmployeeRepo;

@Repository
public class EmployeeCrud {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee fetchEmployee(int id) {
		return employeeRepo.findById(id).get();
	}
	
	public List<Employee> fetchAll(List<Employee> emp) {
		return employeeRepo.findAll();
	}
}
