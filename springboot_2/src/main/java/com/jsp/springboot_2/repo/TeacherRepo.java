package com.jsp.springboot_2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.springboot_2.dto.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer>{
	@Query("select a from Teacher a where a.email=?1")
	public abstract Teacher findByEmail(String email);
	
	
//	Teacher findByEmail(String email);
	
}
