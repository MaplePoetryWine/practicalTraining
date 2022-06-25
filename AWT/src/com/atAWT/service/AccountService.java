package com.atAWT.service;

import com.atAWT.dao.AccountDao;
import com.atAWT.dao.impl.AccountDaoImpl;
import com.atAWT.dao.impl.SavingAccountDao;
import com.atAWT.model.Account;
import com.atAWT.model.SavingAccount;
import com.atAWT.model.U;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Ding
 * @date: 2022/6/24
 * @description: 处理 用户相关请求
 * @modify:
 */

public class AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    private Lock lock = new ReentrantLock();

    /**
     * 处理登录请求，返回登录用户的对象，若为 null 表示该用户不存在
     * @param accountId
     * @param password
     * @return
     */
    public Account login(String accountId, String password) {
        Account account = AccountDaoImpl.map.get(Integer.parseInt(accountId));
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

        Collection<Account> accounts = AccountDaoImpl.map.values();
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
     * @param id 要查询的对象的 id
     * @return 返回一个对应的对象
     */
    public Account selectById(Integer id) {
        return AccountDaoImpl.map.get(id);
    }

    /**
     * 存款
     * @param accountId 要存入的账户 id
     * @param amount 要存入的金额
     * @return 返回是否存入成功
     */
    public boolean deposit(Integer accountId, String password, double amount) {
        Account account = selectById(accountId);
        if (! password.equals(account.getPassword())) return false;
        double balance = account.getBalance();
        try {
            return accountDao.deposit(accountId, amount);
        } catch (IOException e) {
            account.setBalance(balance);
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 取款
     * @param accountId 要取款的 id
     * @param amount 要取款的 金额
     * @return 返回是否成功
     */
    public boolean withdrawMoney(Integer accountId, String password, double amount) {
        Account account = selectById(accountId);
        if (account == null) return false;
        if (! password.equals(account.getPassword())) return false;
        double balance = account.getBalance();
        if (balance < amount) {
            return false;
        } else {
            return accountDao.withdrawMoney(account, amount);
        }
    }



    /**
     * 处理转账请求
     * @param payId 转账用户的 savings 账户 id
     * @param payeeId 收款者 savings 账户 id
     * @param amount 要转账的金额
     * @return 返回 "true" 表示转账成功 ；若转账失败，则返回格式为： "error: 错误提示信息"；如："error: 当前用户不存在" ，或者："error: 用户余额不足"
     */
    public String transfer(Integer payId, Integer payeeId, double amount) {
        lock.lock();
        Account payAccount = AccountDaoImpl.map.get(payId);
        Account payeeAccount = AccountDaoImpl.map.get(payeeId);


        // 用户可能不存在
        if (payAccount == null) {
            return "error: 当前用户不存在";
        }
        if (payeeAccount == null) {
            return "error: 收款用户不存在";
        }

        // 备份用户余额，用于回滚
        double payBalance = payAccount.getBalance();
        double payeeBalance = payeeAccount.getBalance();
        try {

            // 用户余额不足以转账
            if (payAccount.getBalance() - amount < 0) {
                return "error: 用户余额不足";
            }

            payAccount.setBalance(payAccount.getBalance() - amount);
            payeeAccount.setBalance(payAccount.getBalance() + amount);

            return "true";
        } catch (Exception e) {
            if (payAccount.getBalance() != payBalance) {
                payAccount.setBalance(payBalance);
                AccountDaoImpl.map.put(payId, payAccount);
            }
            if (payeeAccount.getBalance() != payeeBalance) {
                payeeAccount.setBalance(payeeBalance);
                AccountDaoImpl.map.put(payeeId, payeeAccount);
            }
            return "error: 系统异常！转账失败";
        } finally {
            U.writeAccount();
            lock.unlock();
        }
    }
}
