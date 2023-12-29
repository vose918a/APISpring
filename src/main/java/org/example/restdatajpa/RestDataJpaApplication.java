package org.example.restdatajpa;

import org.example.restdatajpa.entities.Person;
import org.example.restdatajpa.repositories.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestDataJpaApplication {
    public static void main(String[] args) {

        // Invoke the context(beans context) and the repository
        ApplicationContext context = SpringApplication.run(RestDataJpaApplication.class, args);
//        PersonRepository repository = context.getBean(PersonRepository.class);

        // Create an object to save in the repository

//        Person person1 = new Person(null,"Cesar","Medina","cmmedina@fctunca.edu.py");
//        Person person2 = new Person(null,"Micaela","Medina","mmedina@gmail.com");
//
//        //Save the object to the repository
//
//        repository.save(person1);
//        repository.save(person2);

//        //Show the count of people in the repository
//        System.out.println(repository.findAll().size());
//
//        //Show all the people in the repository
//        System.out.println(repository.findAll());
//
//        //Delete one person from the repository by id
//        repository.deleteById(1L);
//
//        //Show the count of people in the repository
//        System.out.println(repository.findAll().size());
    }

}
