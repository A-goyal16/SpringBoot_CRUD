package org.paycorp.crudspringboot.controller;

import java.util.Optional;

import org.paycorp.crudspringboot.dto.Student;
import org.paycorp.crudspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
@RestController
public class StudentController 
{
	@Autowired
	StudentService service;
	
	@PostMapping("/savestudent")
	public Student savestudent( @RequestBody Student student)
	{
		return service.save(student);
	}
	@GetMapping("/students/{id}")
	public Optional<Student> fetch(@Valid @RequestBody Student student, @PathVariable int id) {
		return service.fetch(student, id);
	}
	
    @PutMapping("/update/{id}")
    public Student update(@RequestBody Student student,@PathVariable int id)
    {
    	return service.update(student,id);
    }
	
	@DeleteMapping("/delete/{id}")
	public Student delete(@RequestBody Student student,@PathVariable int id)
	{
		return service.delete(student,id);	
	}
	
	
	
}
