package com.automation_testing.hibernate.dao;

import com.automation_testing.hibernate.interfaces.CRUDable;
import com.automation_testing.hibernate.pojo.PaymentOrder;
import com.automation_testing.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class PaymentOrderDAO implements CRUDable<PaymentOrder> {

    public PaymentOrder findById(String id) {
        return HibernateUtils.sessionFactory.openSession().get(PaymentOrder.class, id);
    }

    public void saveOrUpdate(PaymentOrder paymentOrder) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(paymentOrder);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void delete(PaymentOrder paymentOrder) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(paymentOrder);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void save(PaymentOrder paymentOrder) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.save(paymentOrder);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void merge(PaymentOrder paymentOrder) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.merge(paymentOrder);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void update(PaymentOrder paymentOrder) {
        Session session = HibernateUtils.sessionFactory.getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(paymentOrder);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public List<PaymentOrder> findAll() {
        return (List<PaymentOrder>) HibernateUtils.sessionFactory.openSession().createQuery("From PaymentOrder ").list();
    }
}