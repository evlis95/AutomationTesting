package com.automation_testing.hibernate.service;

import com.automation_testing.hibernate.dao.DivisionsDAO;
import com.automation_testing.hibernate.pojo.Divisions;


import java.util.List;

public class DivisionService {
    DivisionsDAO dao = new DivisionsDAO();

    public DivisionService() {
    }

    public Divisions findDivision(String id) {
        return dao.findById(id);
    }

    public void saveOrUpdateDivision(Divisions division) {
        dao.saveOrUpdate(division);
    }

    public void deleteDivision(Divisions division) {
        dao.delete(division);
    }

    public void saveDivision(Divisions division) {
        dao.save(division);
    }

    public void updateDivision(Divisions division) {dao.update(division);}

    public void merge(Divisions division) {dao.merge(division);}

    public List<Divisions> findAllDivisions() {
        return dao.findAll();
    }
}
