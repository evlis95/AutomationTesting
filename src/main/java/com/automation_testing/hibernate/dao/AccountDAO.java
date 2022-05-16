package com.automation_testing.hibernate.dao;

import com.automation_testing.hibernate.interfaces.CRUDable;
import com.automation_testing.hibernate.pojo.Account;
import com.automation_testing.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class AccountDAO implements CRUDable<Account> {

    public Account findById(String id) {
        return HibernateUtils.sessionFactory.openSession().get(Account.class, id);
    }

    public void saveOrUpdate(Account account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(account);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Account account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.delete(account);
        session.getTransaction().commit();
        session.close();
    }

    public void save(Account account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.save(account);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Account account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.update(account);
        session.getTransaction().commit();
        session.close();
    }

    public void merge(Account account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.merge(account);
        session.getTransaction().commit();
        session.close();
    }


    public List<Account> findAll() {
        return (List<Account>) HibernateUtils.sessionFactory.openSession().createQuery("From Account").list();
    }
}
