package com.example.proyecto.back.repository;

import com.example.proyecto.back.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/*public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}*/
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
