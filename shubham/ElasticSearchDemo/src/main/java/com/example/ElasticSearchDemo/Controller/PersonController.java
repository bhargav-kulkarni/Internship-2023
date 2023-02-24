package com.example.ElasticSearchDemo.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ElasticSearchDemo.Entity.Person;
import com.example.ElasticSearchDemo.services.IndexService;

@RestController
@RequestMapping("/Indics/")
public class PersonController {


    @Autowired
    IndexService personService;
    @GetMapping("/person/")
    public Iterator<Person> getAllPerson()
    {
        return (Iterator<Person>) personService.getAllPerson().iterator();
    }

    @PostMapping("/person/")
    public  Person addPerson(@RequestBody Person person) {
        return personService.save(person);
    }
    @GetMapping("/person/{id}")
    public Optional<Person> getByID(@PathVariable int id)
    {
        return  personService.getById(id);

    }

    @DeleteMapping("/person/{id}")
    public void deleteById(@PathVariable int id)
    {
       personService.deleteById(id);
    }
}
