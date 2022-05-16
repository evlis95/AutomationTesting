package com.automation_testing.hibernate.dao;

import com.automation_testing.hibernate.interfaces.CRUDable;
import com.automation_testing.hibernate.pojo.Division;
import com.automation_testing.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class DivisionDAO implements CRUDable<Division> {

    public Division findById(String id) {
        return HibernateUtils.sessionFactory.openSession().get(Division.class, id);
    }

    public void saveOrUpdate(Division division) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(division);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Division division) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.delete(division);
        session.getTransaction().commit();
        session.close();
    }

    public void save(Division division) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.save(division);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Division division) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.update(division);
        session.getTransaction().commit();
        session.close();
    }

    public void merge(Division division) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.merge(division);
        session.getTransaction().commit();
        session.close();
    }


    public List<Division> findAll() {
        return (List<Division>) HibernateUtils.sessionFactory.openSession().createQuery("From Division").list();
    }
}
