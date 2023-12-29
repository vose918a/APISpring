package org.example.restdatajpa.services;

import org.example.restdatajpa.entities.Person;
import org.example.restdatajpa.repositories.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonService {
    //Transfer the data manipulation methods from the controller to this class
    //Attributes
    PersonRepository repository;
    //Constructor
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    //Get the list of people from the repository
    public List<Person> getAllPersons() {return repository.findAll();}
    //Get one person from the repository by id
    public Optional<Person> getPersonById(Long id){return repository.findById(id);}
    //Create a new person in the repository
    public Person createPerson(Person person){
        return repository.save(person);
    }
    //Update a person in the repository
    public boolean updatePerson(Long id,Person newPerson){
        return repository.findById(id).map(oldPerson -> {
            oldPerson.setName(newPerson.getName());
            oldPerson.setLastname(newPerson.getLastname());
            oldPerson.setEmail(newPerson.getEmail());
            repository.save(oldPerson);
            return true;
        }).orElse(false);
    }
    //Delete a person in the repository
    public boolean deletePersonById(Long id){
        return repository.findById(id).map(Person -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }
    //Delete all people from the repository
    public void deleteAllPersons(){repository.deleteAll();}
}
