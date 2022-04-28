package com.automation_testing.hibernate.dao;

import com.automation_testing.hibernate.pojo.Accounts;
import com.automation_testing.hibernate.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class AccountsDAO {


    public Accounts findById(String id) {
        return HibernateUtils.sessionFactory.openSession().get(Accounts.class, id);
    }

    public void saveOrUpdate(Accounts account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(account);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Accounts account) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.delete(account);
        session.getTransaction().commit();
        session.close();
    }

    public List<Accounts> findAll() {
        return (List<Accounts>) HibernateUtils.sessionFactory.openSession().createQuery("From Accounts ").list();
    }
}
