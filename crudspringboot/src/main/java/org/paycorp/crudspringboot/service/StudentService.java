package org.paycorp.crudspringboot.service;

import java.util.Optional;

import org.paycorp.crudspringboot.dao.StudentDao;
import org.paycorp.crudspringboot.dto.Student;
import org.paycorp.crudspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class StudentService 
{
	@Autowired
	StudentDao dao;
	
	@Autowired
	StudentRepository studentrepository;
	
	public Student save(Student student) 
	{
		System.out.println("the data is inserted sucessfully");
		return dao.save(student);
	}
	
	
	public Optional<Student> fetch(@Valid Student student, int id) 
	{
		return dao.fetch(student, id);
	}
	
	
	public Student delete(Student student, int id) 
	{
		dao.delete(student, id);
		System.out.println("record deleted");
		return student;
	}
	
	public Student update(Student student, int id) {
		studentrepository.findById(id).ifPresent(stu -> {
			stu.setName(stu.getName());
			stu.setAge(stu.getAge());
			stu.setAddress(stu.getAddress());
			studentrepository.save(stu);
		});
		return student;
	}
	
}
