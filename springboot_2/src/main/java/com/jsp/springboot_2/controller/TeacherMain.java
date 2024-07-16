package com.jsp.springboot_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_2.dao.TeacherCrud;
import com.jsp.springboot_2.dto.Teacher;
@RestController
public class TeacherMain {
	@Autowired
	private TeacherCrud crud;
	
	@PostMapping("/saveteacher")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		return crud.saveTeacher(teacher);
	}
	
	@GetMapping("/fetchteacher")
	public Teacher fetchTeacher(@RequestParam int id) {
		return crud.fetchById(id);
	}
	
	@DeleteMapping("/delete")
	public Teacher deleteById(@RequestParam int id) {
		return crud.deleteById(id);
	}
	
	@PutMapping("/update")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		return crud.updateTeacher(teacher);
	}
	
	@PostMapping("/login")
	public String loginn(@RequestParam String email,String pwd) {
		return crud.login(email, pwd);
	}
	
	@PostMapping("/update")
	public Teacher update(@RequestBody Teacher teacher) {
		return crud.update(teacher);
	}
	@PostMapping("/fetchall")
	public List<Teacher> fetchAll(){
		return crud.fetchAll();
	}
}
