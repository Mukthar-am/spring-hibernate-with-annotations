package com.vmware.advalidate.application;

import java.util.List;

import com.vmware.advalidate.config.Configurations;
import com.vmware.advalidate.model.Person;
import com.vmware.advalidate.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ValidatorMain {
    private static Logger logger = LoggerFactory.getLogger(ValidatorMain.class);

    public static void main(String[] args) {
        logger.info("ActiveDirectory ACL validations.");

        new ValidatorMain().validate();
    }

    private void validate() {
        logger.info("=== validator ===");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configurations.class);

        //UserService userService = context.getBean(UserService.class);
        PersonService personService = context.getBean(PersonService.class);


        // Add Users
        Person person = new Person();
        person.setName("Maniyar"); person.setCountry("Gowdanapalya");
        personService.save(person);


        List<Person> people = personService.list();
        for (Person p : people) {
            logger.info("Person:- "+ p.toString());
        }

        context.close();
    }
}
