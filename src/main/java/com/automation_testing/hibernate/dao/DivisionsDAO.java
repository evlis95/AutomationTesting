package com.automation_testing.hibernate.dao;

import com.automation_testing.hibernate.interfaces.CRUDable;
import com.automation_testing.hibernate.pojo.Divisions;
import com.automation_testing.hibernate.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class DivisionsDAO implements CRUDable<Divisions> {

    public Divisions findById(String id) {
        return HibernateUtils.sessionFactory.openSession().get(Divisions.class, id);
    }

    public void saveOrUpdate(Divisions divisions) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(divisions);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Divisions divisions) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.delete(divisions);
        session.getTransaction().commit();
        session.close();
    }

    public void save(Divisions divisions) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.save(divisions);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Divisions divisions) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.update(divisions);
        session.getTransaction().commit();
        session.close();
    }

    public void merge(Divisions divisions) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.merge(divisions);
        session.getTransaction().commit();
        session.close();
    }



    public List<Divisions> findAll() {
        return (List<Divisions>) HibernateUtils.sessionFactory.openSession().createQuery("From Divisions").list();
    }
}
