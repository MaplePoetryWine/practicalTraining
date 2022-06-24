package com.atAWT.service;

import com.atAWT.dao.AccountDao;
import com.atAWT.dao.impl.AccountDaoImpl;
import com.atAWT.model.Account;
import com.atAWT.model.SavingAccount;
import com.atAWT.model.U;

import java.io.IOException;
import java.util.*;

/**
 * @author: Ding
 * @date: 2022/6/24
 * @description: 处理 用户相关请求
 * @modify:
 */

public class AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

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
//        HashMap<Integer, Account> accountMap = U.accountMap;
//        Collection<Account> accounts = accountMap.values();

        List<Account> accounts = AccountDaoImpl.list;
        Set<String> set = new HashSet<>();
        for (Account otherAccount : accounts) {
            set.add(otherAccount.getPersonID());
        }

        if (! set.add(account.getPersonID())) {
            return null;
        }

        try {
            if (/*U.addCount(account)*/ accountDao.register(account)) {
                return account;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据 id 查询对象
     * @param id
     * @return
     */
    @Deprecated
    public Account selectById(Integer id) {
        return U.accountMap.get(id);
    }
}
