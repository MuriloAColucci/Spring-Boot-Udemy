package br.com.udemy.services;

import br.com.udemy.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all People!");

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++){
            Person person = mochPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person findById(String id){
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Murilo");
        person.setLastName("Colucci");
        person.setAddress("Paraisópolis - Minas Gerais - Brazil");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person){
        logger.info("Creating one Person!");

        return person;
    }

    public Person update(Person person){
        logger.info("Updating one Person!");

        return person;
    }

    public void delete(String id){
        logger.info("Deleting one Person!");
    }

    private Person mochPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Some Address in Brazil");
        person.setGender("Male");

        return person;
    }
}
