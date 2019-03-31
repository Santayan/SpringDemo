package com.example.SpringDemo.api;

import com.example.SpringDemo.repository.PersonRepo;
import com.example.SpringDemo.model.Person;
import com.example.SpringDemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    private final PersonService personService;


    @PostMapping("/add")
    public String addPerson(@RequestBody Person person){
        personService.addPerson(person);
        personRepo.save(person);
        return "Saved Person With ID - " + person.getId() + ", and Name - " + person.getName() + " Successfully";

    }

    @GetMapping("/view")
    public List<Person> getAllPeople(){
        personRepo.findAll();
        return personService.getAllPeople();

    }
}
