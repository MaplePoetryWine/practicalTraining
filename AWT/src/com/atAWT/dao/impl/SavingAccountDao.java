package com.atAWT.dao.impl;

import com.atAWT.model.SavingAccount;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Ding
 * @date: 2022/6/24
 * @description:
 * @modify:
 */

public class SavingAccountDao {

    public static Map<Integer, SavingAccount> map = new HashMap<>();

    /**
     * 存款
     * @param accountId
     * @param amount
     * @return
     */
    public boolean deposit(Integer accountId, double amount) {
        SavingAccount savingAccount = map.get(accountId);
        if (savingAccount == null) {
            return false;
        }
        savingAccount.setBalance(savingAccount.getBalance() + amount);
        return true;
    }
}
