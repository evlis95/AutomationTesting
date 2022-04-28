package com.automation_testing.hibernate.service;


import com.automation_testing.hibernate.dao.OrganizationsDAO;
import com.automation_testing.hibernate.pojo.Organizations;

import java.util.List;

public class OrganizationService {

    OrganizationsDAO dao = new OrganizationsDAO();

    public OrganizationService() {
    }

    public Organizations findOrg(String id) {
        return dao.findById(id);
    }

    public void save(Organizations org) {
        dao.save(org);
    }

    public void merge(Organizations org) {
        dao.merge(org);
    }

    public void saveOrUpdate(Organizations org) {
        dao.saveOrUpdate(org);
    }


    public void deleteOrg(Organizations org) {
        dao.delete(org);
    }

    public List<Organizations> findAllOrg() {
        return dao.findAll();
    }

}

