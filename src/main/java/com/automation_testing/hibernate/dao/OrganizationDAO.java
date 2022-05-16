package com.automation_testing.hibernate.dao;

import com.automation_testing.hibernate.interfaces.CRUDable;
import com.automation_testing.hibernate.pojo.Organization;
import com.automation_testing.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class OrganizationDAO implements CRUDable<Organization> {

    public Organization findById(String id) {
        return HibernateUtils.sessionFactory.openSession().get(Organization.class, id);
    }

    public void saveOrUpdate(Organization organization) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(organization);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Organization organization) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.delete(organization);
        session.getTransaction().commit();
        session.close();
    }

    public void save(Organization organization) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.save(organization);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Organization organization) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.update(organization);
        session.getTransaction().commit();
        session.close();
    }

    public void merge(Organization organization) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.merge(organization);
        session.getTransaction().commit();
        session.close();
    }


    public List<Organization> findAll() {
        return (List<Organization>) HibernateUtils.sessionFactory.openSession().createQuery("From Organization").list();
    }
}
