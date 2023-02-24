package com.example.ElasticSearchDemo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ElasticSearchDemo.Entity.Person;
import com.example.ElasticSearchDemo.Repository.IndexRepository;


@Service
public class IndexService {

    @Autowired
    private IndexRepository indexRepository;
    public Iterable<Person> getAllPerson()
    {
        return indexRepository.findAll();
    }
    public Person save(Person person)
    {
        indexRepository.save(person);
        return  person;
    }

    public Optional<Person> getById(int id) {
        return indexRepository.findById(""+id);
    }

    public void  deleteById(int id) {
       indexRepository.deleteById(""+id);

    }



}
