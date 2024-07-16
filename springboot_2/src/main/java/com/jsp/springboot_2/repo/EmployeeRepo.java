package com.jsp.springboot_2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_2.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
}
