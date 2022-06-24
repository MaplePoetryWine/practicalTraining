package com.atAWT.service;

import com.atAWT.model.Account;
import com.atAWT.model.SavingAccount;
import com.atAWT.model.U;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Ding
 * @date: 2022/6/24
 * @description: 处理 用户相关请求
 * @modify:
 */

public class AccountService {

    /**
     * 处理登录请求，返回登录用户的对象，若为 null 表示该用户不存在
     * @param accountId
     * @param password
     * @return
     */
    public Account login(String accountId, String password) {
        Account account = U.accountMap.get(Integer.parseInt(accountId));
        if (account != null
                && password != null
                && password.equals(account.getPassword())) {
            return account;
        } else {
            return null;
        }
    }

    /**
     * 处理注册请求
     * @param account 返回注册用户的对象，若为 null 则注册失败
     * @return
     */
    public Account register(Account account) {
        HashMap<Integer, SavingAccount> savingMap = U.savingMap;
        Collection<SavingAccount> savingAccounts = savingMap.values();
        Set<String> set = new HashSet<>();
        for (SavingAccount savingAccount : savingAccounts) {
            set.add(savingAccount.getPersonID());
        }

        if (! set.add(account.getPersonID())) {
            return null;
        }

        if (U.addCount(account)) {
            return account;
        } else {
            return null;
        }

    }
}
