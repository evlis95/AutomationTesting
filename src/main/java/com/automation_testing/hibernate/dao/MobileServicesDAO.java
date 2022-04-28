package com.automation_testing.hibernate.dao;

import com.automation_testing.hibernate.pojo.MobileServices;
import com.automation_testing.hibernate.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

 public class MobileServicesDAO {

    public MobileServices findById(String id) {
        return HibernateUtils.sessionFactory.openSession().get(MobileServices.class, id);
    }

    public void save(MobileServices mobileServices) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.save(mobileServices);
        session.getTransaction().commit();
        session.close();
    }

    public void update(MobileServices mobileServices) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.update(mobileServices);
        session.getTransaction().commit();
        session.close();
    }

     public void saveOrUpdate(MobileServices mobileServices) {
         Session session = HibernateUtils.sessionFactory.getCurrentSession();
         session.getTransaction().begin();
         session.saveOrUpdate(mobileServices);
         session.getTransaction().commit();
         session.close();
     }

     public void merge(MobileServices mobileServices) {
         Session session = HibernateUtils.sessionFactory.getCurrentSession();
         session.getTransaction().begin();
         session.merge(mobileServices);
         session.getTransaction().commit();
         session.close();
     }

    public void delete(MobileServices mobileServices) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.delete(mobileServices);
        session.getTransaction().commit();
        session.close();
    }

    public List<MobileServices> findAll() {
        return (List<MobileServices>) HibernateUtils.sessionFactory.openSession().createQuery("From MobileServices").list();
    }
}
