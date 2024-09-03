package com.app.controller;

import com.app.entity.Person;
import com.app.services.api.PersonService;
import com.app.dto.PersonDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PersonController{

    private PersonService personService;

    @GetMapping("person/getPersons")
    public Object getAllPerson(){
        return personService.getAllPerson();
    }

    @PostMapping("person/createPerson")
    @ResponseBody
    public Person createPerson(@RequestBody PersonDto personDto){
        return personService.addPerson(personDto.getId(),personDto.getName());
    }
}
