package com.automation_testing.hibernate.service;

import com.automation_testing.hibernate.dao.PaymentOrderDAO;
import com.automation_testing.hibernate.pojo.PaymentOrder;

import java.util.List;

public class PaymentOrderService {
    PaymentOrderDAO dao = new PaymentOrderDAO();

    public PaymentOrderService() {
    }

    public PaymentOrder findPaymentOrder(String id) {
        return dao.findById(id);
    }

    public void saveOrUpdatePaymentOrder(PaymentOrder paymentOrder) {
        dao.saveOrUpdate(paymentOrder);
    }

    public void deletePaymentOrder(PaymentOrder paymentOrder) {
        dao.delete(paymentOrder);
    }

    public void savePaymentOrder(PaymentOrder paymentOrder) {
        dao.save(paymentOrder);
    }

    public void updatePaymentOrder(PaymentOrder paymentOrder) {dao.update(paymentOrder);}

    public void merge(PaymentOrder paymentOrder) {dao.merge(paymentOrder);}

    public List<PaymentOrder> findAllPaymentOrder() {
        return dao.findAll();
    }
}
