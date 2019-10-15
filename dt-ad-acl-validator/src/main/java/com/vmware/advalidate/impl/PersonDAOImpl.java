package com.vmware.advalidate.impl;


import javax.persistence.TypedQuery;

import java.util.List;

import com.vmware.advalidate.dao.PersonDAO;
import com.vmware.advalidate.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Person p) {
        sessionFactory.getCurrentSession().save(p);
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public List<Person> list() {
//        Session session = this.sessionFactory.openSession();
//        List<Person> personList = session.createQuery("from Person").list();
//        session.close();
//        return personList;
//    }

    @Override
    public List<Person> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Person> query=sessionFactory.getCurrentSession().createQuery("from Person");
        return query.getResultList();
    }
}
