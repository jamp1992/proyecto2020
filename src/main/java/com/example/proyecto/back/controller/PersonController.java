package com.example.proyecto.back.controller;


import com.example.proyecto.back.exception.ResourceNotFoundException;
import com.example.proyecto.back.model.Person;
import com.example.proyecto.back.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> getAllPerson() {
        return (List<Person>) personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Integer personId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + personId));
        return ResponseEntity.ok().body(person);
    }
    @PostMapping("/person")
    public String createEmployee(@RequestBody Person person) {
        personRepository.save(person);
        return "Employee saved";
    }

    @DeleteMapping("/person/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        personRepository.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
