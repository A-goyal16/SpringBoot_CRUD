package org.paycorp.crudspringboot.repository;

import java.util.Optional;

import org.paycorp.crudspringboot.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>
{
	void save(Optional<Student>s);
}
