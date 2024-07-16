package com.jsp.springboot_2.dao;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_2.dto.Teacher;
import com.jsp.springboot_2.repo.TeacherRepo;

@Repository
public class TeacherCrud {
	@Autowired
	private TeacherRepo teacherRepo;
	
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepo.save(teacher);
	}
	
	public Teacher fetchById(int id) {
		Optional<Teacher> db = teacherRepo.findById(id);
//		if(db.isPresent())
//			return teacherRepo.findById(id).get();
//		else 
//			return null;
		
		if(db.isEmpty())
			return null;
		else 
			return teacherRepo.findById(id).get();
	}
	
	public Teacher deleteById(int id) {
		Optional<Teacher> db = teacherRepo.findById(id);
		if(db.isPresent()) {
			Teacher tdb = db.get();
			teacherRepo.deleteById(id);
			return tdb;
		}
		else 
			return null;	
	}
	
	public Teacher updateTeacher(Teacher teacher) {
		Optional<Teacher> db = teacherRepo.findById(teacher.getId());
		if(db.isPresent()){
			return teacherRepo.save(teacher);
		}
		else 
			return null;	
	}
	
	public String login(String email,String pwd) {
		Teacher db = teacherRepo.findByEmail(email);
		if(db!=null) {
			if(db.getPwd().equals(pwd)) {
				return "login success";
			}
			else {
				return "wrong pwd";
			}
		}
		else {
			return "email not found";
		}
	}
	public Teacher update(Teacher teacher) {
		Optional<Teacher> db = teacherRepo.findById(teacher.getId());
		if(db.isPresent()) {
			Teacher db1 = teacherRepo.findById(teacher.getId()).get();
			if(teacher.getName()==null) {
				teacher.setName(db1.getName());
			}
			if(teacher.getEmail()==null) {
				teacher.setEmail(db1.getEmail());
			}
			if(teacher.getId()==0) {
				teacher.setId(db1.getId());
			}
			if(teacher.getPhone()==0) {
				teacher.setPhone(db1.getPhone());
			}
			if(teacher.getPwd()==null) {
				teacher.setPwd(db1.getPwd());
			}
			if(teacher.getSubject()==null) {
				teacher.setSubject(db1.getSubject());
			}
			return teacherRepo.save(teacher);
		}
		else {
			return null;
		}
	}
	
	public List<Teacher> fetchAll(){
		return teacherRepo.findAll();
	}
}
