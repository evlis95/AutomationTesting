package com.automation_testing.hibernate.service;

import com.automation_testing.hibernate.dao.MobileServicesDAO;
import com.automation_testing.hibernate.pojo.MobileServices;

import java.util.List;

public class MobileServicesService {

    MobileServicesDAO dao = new MobileServicesDAO();

    public MobileServicesService() {
    }

    public MobileServices findOrg(String id) {
        return dao.findById(id);
    }

    public void save(MobileServices serMob) {
        dao.save(serMob);
    }

    public void merge(MobileServices serMob) {
        dao.merge(serMob);
    }

    public void saveOrUpdate(MobileServices serMob) {
        dao.saveOrUpdate(serMob);
    }


    public void deleteOrg(MobileServices serMob) {
        dao.delete(serMob);
    }

    public List<MobileServices> findAllSerMob() {
        return dao.findAll();
    }
}
