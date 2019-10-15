package com.vmware.advalidate.service;

import java.util.List;

import com.vmware.advalidate.dao.PersonDAO;
import com.vmware.advalidate.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * M: Service class for transationality on Person table
 */

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    @Transactional
    @Override
    public void save(Person p) {
        personDAO.save(p);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> list() {
        return personDAO.list();
    }
}
