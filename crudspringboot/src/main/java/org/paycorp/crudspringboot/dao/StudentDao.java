package org.paycorp.crudspringboot.dao;

import java.util.Optional;

import org.paycorp.crudspringboot.dto.Student;
import org.paycorp.crudspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
@Repository
public class StudentDao 
{
	@Autowired
	StudentRepository repository;
	
	
	public Student save(@RequestBody Student student)
	{
		return repository.save(student);
	}
	public Optional<Student> fetch(@Valid Student student, int id) {
		return repository.findById(id);
	}
	
	public void delete(Student student, int id) {
		 repository.deleteById(id);
	}
}
