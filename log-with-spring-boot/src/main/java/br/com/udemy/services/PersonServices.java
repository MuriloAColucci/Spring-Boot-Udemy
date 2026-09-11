package br.com.udemy.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.udemy.exception.ResourceNotFoundException;
import br.com.udemy.model.Person;
import br.com.udemy.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all People!");

        return repository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one Person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));
    }

    public Person create(Person person){
        logger.info("Creating one Person!");

        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one Person!");

        Person entity =  repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id!"));

        repository.delete(entity);
    }
}
