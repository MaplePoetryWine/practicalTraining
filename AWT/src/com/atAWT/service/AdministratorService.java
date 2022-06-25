package com.atAWT.service;

import com.atAWT.dao.impl.AccountDaoImpl;
import com.atAWT.model.Account;

import java.util.Collection;

public class AdministratorService {

    /**
     * @return 返回所有已注册的用户
     */
    public Collection<Account> getAllAccount() {
        return AccountDaoImpl.map.values();
    }

    /**
     *
     * @return 返回所有用户的余额
     */
    public double getAllAccountBalance() {
        Collection<Account> allAccount = getAllAccount();
        double balance = 0;
        for (Account account : allAccount) {
            balance += account.getBalance();
        }
        return balance;
    }
}
