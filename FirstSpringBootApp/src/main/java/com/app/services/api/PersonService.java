package com.app.services.api;

import com.app.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PersonService {

    public Person addPerson(Long id, String name);
    public List<Person> getAllPerson();
}
