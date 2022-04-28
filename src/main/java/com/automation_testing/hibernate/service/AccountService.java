package com.automation_testing.hibernate.service;

import com.automation_testing.hibernate.dao.AccountsDAO;
import com.automation_testing.hibernate.pojo.Accounts;

import java.util.List;

public class AccountService {
    AccountsDAO dao = new AccountsDAO();

    public AccountService() {
    }

    public Accounts findAccount(String id) {
        return dao.findById(id);
    }

    public void saveOrUpdateAccount(Accounts account) {
        dao.saveOrUpdate(account);
    }

    public void deleteAccounts(Accounts account) {
        dao.delete(account);
    }

    public List<Accounts> findAllAccounts() {
        return dao.findAll();
    }
}
