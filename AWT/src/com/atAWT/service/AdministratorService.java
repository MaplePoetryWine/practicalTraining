package com.atAWT.service;

import com.atAWT.dao.impl.AccountDaoImpl;
import com.atAWT.model.Account;
import com.atAWT.model.U;

import java.util.*;

public class AdministratorService {

    /**
     * @return 返回所有已注册的用户
     */
    public Collection<Account> getAllAccount() {
        return U.accountMap.values();
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

    /**
     *
     * @return 返回所有用户按照余额排名的一个有序集合
     */
    public LinkedHashMap<Integer, Account> getAllAccountOrderByBalance() {
        Collection<Account> accounts = getAllAccount();
        Account[] accountArray = accounts.toArray(new Account[0]);
        Arrays.sort(accountArray, (o1, o2) -> {
            Double o1Balance = o1.getBalance();
            Double o2Balance = o2.getBalance();
            return o2Balance.compareTo(o1Balance); // 降序
        });

        LinkedHashMap<Integer, Account> accountMap = new LinkedHashMap<>();
        for (Account account : accountArray) {
            accountMap.put(account.getID(), account);
        }
        return accountMap;
    }
}
