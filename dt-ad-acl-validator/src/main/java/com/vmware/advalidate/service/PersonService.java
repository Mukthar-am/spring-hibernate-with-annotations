package com.vmware.advalidate.service;

import java.util.List;

import com.vmware.advalidate.model.Person;


public interface PersonService {
    public void save(Person p);
    public List<Person> list();
}
