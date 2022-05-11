package com.automation_testing.hibernate.dao;


import com.automation_testing.hibernate.interfaces.CRUDable;
import com.automation_testing.utils.HibernateUtils;
import com.automation_testing.hibernate.pojo.Organizations;
import org.hibernate.Session;

import java.util.List;

public class OrganizationsDAO implements CRUDable<Organizations> {

    public Organizations findById(String id) {
        return HibernateUtils.sessionFactory.openSession().get(Organizations.class, id);
    }

    public void save(Organizations organizations) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(organizations);
        session.getTransaction().commit();
        session.close();
    }

    public void merge(Organizations organizations) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.merge(organizations);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Organizations organizations) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.merge(organizations);
        session.getTransaction().commit();
        session.close();
    }

    public void saveOrUpdate(Organizations organizations) {
        Session session = HibernateUtils.sessionFactory.openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(organizations);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Organizations organizations) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.delete(organizations);
        session.getTransaction().commit();
        session.close();
    }

    public List<Organizations> findAll() {
        return (List<Organizations>) HibernateUtils.sessionFactory.openSession().createQuery("From Organizations").list();
    }

}
