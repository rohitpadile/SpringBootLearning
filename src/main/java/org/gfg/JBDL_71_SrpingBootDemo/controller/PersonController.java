package org.gfg.JBDL_71_SrpingBootDemo.controller;

import org.gfg.JBDL_71_SrpingBootDemo.model.Person;
import org.gfg.JBDL_71_SrpingBootDemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

//    @Autowired
    PersonService personService;

    @Autowired
    PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        // validations
        // return the correct response fetched from service
        return personService.getPersons();
    }

    @PostMapping("/person")
    public Integer createPerson(@RequestBody List<Person> person) {
        for(Person p : person) {
            if (p.getName() == null || p.getId() == null) {
                throw new IllegalArgumentException("Mandatory parameters are null");
            }
            personService.createPerson(p);
        }
        return 0;
    }
}
