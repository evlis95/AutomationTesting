package com.automation_testing.hibernate.dao;

import com.automation_testing.hibernate.interfaces.CRUDable;
import com.automation_testing.hibernate.pojo.Accounts;
import com.automation_testing.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class AccountsDAO implements CRUDable<Accounts> {


    public Accounts findById(String id) {
        return HibernateUtils.sessionFactory.openSession().get(Accounts.class, id);
    }

    public void saveOrUpdate(Accounts account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(account);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void delete(Accounts account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(account);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void save(Accounts account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.save(account);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void merge(Accounts account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.merge(account);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void update(Accounts account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(account);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }


    public List<Accounts> findAll() {
        return (List<Accounts>) HibernateUtils.sessionFactory.openSession().createQuery("From Accounts ").list();
    }
}
