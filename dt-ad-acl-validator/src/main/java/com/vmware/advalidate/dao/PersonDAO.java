package com.vmware.advalidate.dao;

import java.util.List;

import com.vmware.advalidate.model.Person;

public interface PersonDAO {
    public void save(Person p);
    public List<Person> list();
}

