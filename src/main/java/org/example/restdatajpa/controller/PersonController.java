package org.example.restdatajpa.controller;

import org.example.restdatajpa.entities.Person;
import org.example.restdatajpa.repositories.PersonRepository;
import org.example.restdatajpa.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    //Attributes
    private PersonService service;

    //Constructor
    public PersonController(PersonService service) {
        this.service = service;
    }

    /**
     * GET Method to get all person of the repository
     * http://localhost:8080/api/persons*
     */
    @GetMapping("/api/Persons")
    public List<Person> findAll() {
        return service.getAllPersons();
    }

    /**
     * GET Method to get person of the repository by id
     * http://localhost:8080/api/Person
     */
    @GetMapping("/api/Person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return service.getPersonById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /** POST Method for creating a new person object for save in the repository
     * http://localhost:8080/api/Person
     */
    @PostMapping("/api/Person")
    public Person createPerson(@RequestBody Person person){
        return service.createPerson(person);
    }

    /**
     * PUT Method for updating a person object
     * http://localhost:8080/api/Person
     */
    @PutMapping("/api/Person/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable Long id, @RequestBody Person newPerson) {
        return  service.updatePerson(id, newPerson) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    /**DELETE Method from the repository
     * http://localhost:8080/api/Person/{id}
     */
    @DeleteMapping("/api/Person/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable Long id){
        return  service.deletePersonById(id) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    /**DELETE Method for all repository objects
     * http://localhost:8080/api/Persons
     */
    @DeleteMapping("/api/Persons")
    public void deleteAllPersons(){
        service.deleteAllPersons();
    }
}
