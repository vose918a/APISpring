package org.example.restdatajpa.controller;

import org.example.restdatajpa.entities.Person;
import org.example.restdatajpa.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
    //Attributes
    private final PersonService service;
    private final Logger log = LoggerFactory.getLogger(PersonController.class);

    //Constructor
    public PersonController(PersonService service) {
        this.service = service;
        log.info("the Swagger service is available at http://localhost:8080/doc/swagger-ui.html");
    }

    /**
     * GET Method to get all person of the repository
     * http://localhost:8080/api/persons
     */
    @GetMapping("/Persons")
    public List<Person> findAll() {
        log.info("Method findAll is called");
        return service.getAllPersons();
    }

    /**
     * GET Method to get person of the repository by id
     * http://localhost:8080/api/Person
     */
    @GetMapping("/Person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        log.info("Method getPersonById is called");
        return service.getPersonById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /** POST Method for creating a new person object for save in the repository
     * http://localhost:8080/api/Person
     */
    @PostMapping("/Person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        log.info("createPerson method is called");
        return person.getId() != null ?
                ResponseEntity.badRequest().build() : ResponseEntity.ok(service.createPerson(person));
    }

    /**
     * PUT Method for updating a person object
     * http://localhost:8080/api/Person
     */
    @PutMapping("/Person")
    public ResponseEntity<Person> updatePerson(@RequestBody Person newPerson) {
        log.info("updatePerson method is called");
        return  service.updatePerson(newPerson) ?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    /**DELETE Method from the repository
     * http://localhost:8080/api/Person/{id}
     */
    @DeleteMapping("/Person/{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable Long id){
        log.info("deletePersonById method is called");
        return  service.deletePersonById(id) ?
                ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**DELETE Method for all repository objects
     * http://localhost:8080/api/Persons
     */
    @DeleteMapping("/Persons")
    public ResponseEntity<Person> deleteAllPersons(){
        log.warn("deleteAllPersons method is called");
        service.deleteAllPersons();
        return ResponseEntity.noContent().build();
    }
}
