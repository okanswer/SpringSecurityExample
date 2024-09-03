package com.app.services.impl;

import com.app.entity.Person;
import com.app.repository.PersonRepository;
import com.app.services.api.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public Person addPerson(Long id, String name) {
        Person newPerson = new Person(id,name);
        personRepository.save(newPerson);
        return newPerson;
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> personList = personRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return personList;
    }
}
