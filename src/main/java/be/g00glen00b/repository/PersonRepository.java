package be.g00glen00b.repository;

import be.g00glen00b.model.Person;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {


}
