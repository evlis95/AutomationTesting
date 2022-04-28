package com.automation_testing.hibernate.dao;

import com.automation_testing.hibernate.pojo.PaymentOrder;
import com.automation_testing.hibernate.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class PaymentOrderDAO {

    public PaymentOrder findById(String id) {
        return HibernateUtils.sessionFactory.openSession().get(PaymentOrder.class, id);
    }

    public void saveOrUpdate(PaymentOrder paymentOrder) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.saveOrUpdate(paymentOrder);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(PaymentOrder paymentOrder) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.delete(paymentOrder);
        session.getTransaction().commit();
        session.close();
    }
    public void save(PaymentOrder paymentOrder) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.save(paymentOrder);
        session.getTransaction().commit();
        session.close();
    }

    public void merge(PaymentOrder paymentOrder) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.merge(paymentOrder);
        session.getTransaction().commit();
        session.close();
    }

    public void update(PaymentOrder paymentOrder) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.update(paymentOrder);
        session.getTransaction().commit();
        session.close();
    }

    public List<PaymentOrder> findAll() {
        return (List<PaymentOrder>) HibernateUtils.sessionFactory.openSession().createQuery("From PaymentOrder ").list();
    }
}