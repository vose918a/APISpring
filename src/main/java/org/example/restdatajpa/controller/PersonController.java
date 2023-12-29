package org.example.restdatajpa.controller;

import org.example.restdatajpa.entities.Person;
import org.example.restdatajpa.repositories.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    //Atributes
    private PersonRepository repository;

    //Constructor
    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    /**
     * GET Method to get all the person of the repository
     * http://localhost:8080/api/persons*
     */
    @GetMapping("/api/Persons")
    public List<Person> findAll() {
        return repository.findAll();
    }

    /**
     * GET Method to get person of the repository by id
     * http://localhost:8080/api/Person
     */
    @GetMapping("/api/Person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> PersonOtp = repository.findById(id);
        //1st option more large
//        if(PersonOtp.isPresent())
//            return ResponseEntity.ok(PersonOtp.get());
//        else
//            return ResponseEntity.notFound().build();
        //2nd option,
        return PersonOtp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /** POST Method for creating a new person object for save in the repository
     * http://localhost:8080/api/Person
     */
    @PostMapping("/api/Person")
    public Person createPerson(@RequestBody Person person){
        return repository.save(person);
    }

    /**
     * TODO: PUT Method for updating a person object
     * http://localhost:8080/api/Person
     */
    @PutMapping("/api/Person/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable Long id, @RequestBody Person newPerson) {
        return repository.findById(id)
                .map(existingPerson -> {
                    existingPerson.setName(newPerson.getName());
                    existingPerson.setLastname(newPerson.getLastname());
                    existingPerson.setEmail(newPerson.getEmail());
                    repository.save(existingPerson);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    


    /**TODO: DELETE Method from the repository
     * http://localhost:8080/api/Person/{id}
     */
    @DeleteMapping("/api/Person/{id}")
    public void deletePerson(@PathVariable Long id){
        repository.deleteById(id);
    }

    /**TODO: DELETE Method for all repository objects
     * http://localhost:8080/api/Persons
     */
    @DeleteMapping("/api/Persons")
    public void deleteAllPersons(){
        repository.deleteAll();
    }
}
