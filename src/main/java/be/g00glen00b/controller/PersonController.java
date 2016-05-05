package be.g00glen00b.controller;


import java.util.List;

import be.g00glen00b.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.g00glen00b.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> findPersons() {
        return repo.findAll();
    }


    @RequestMapping(method = RequestMethod.POST)
    public Person addPerson(@RequestBody Person item) {
        return repo.save(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Person updatePerson(@RequestBody Person updatedPerson, @PathVariable String id) {
        updatedPerson.setId(id);
        return repo.save(updatedPerson);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable String id) {
        repo.delete(id);
    }
}