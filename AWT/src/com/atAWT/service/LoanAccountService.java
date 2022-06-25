package com.atAWT.service;

import com.atAWT.model.Account;
import com.atAWT.model.LoanAccount;
import com.atAWT.model.U;

/**
 * @author: Ding
 * @date: 2022/6/25
 * @description:
 * @modify:
 */

public class LoanAccountService {

    private AccountService accountService = new AccountService();

    /**
     * 给用户开通贷款账户
     * @param accountId 要开通贷款账户的 id
     * @return 返回开通的贷款账户。若为 null 表示其贷款账户已开通，请调用 {@link #selectLoanAccountById(Integer accountId)}
     */
    public LoanAccount openLoanAccount(Integer accountId) {
        Account account = accountService.selectById(accountId);
        LoanAccount loanAccount = selectLoanAccountById(accountId);
        if (loanAccount == null) {
            LoanAccount newLoanAccount = new LoanAccount(account);
            U.accountMap.put(accountId, newLoanAccount);
            U.write();
            return newLoanAccount;
        }
        return null;
    }

    /**
     * 根据 id 查询已经开通的贷款账户
     * @param accountId 要查询的贷款账户的 id
     * @return 返回查询到的 贷款账户，若为 null 表示该用户未开通贷款账户
     */
    public LoanAccount selectLoanAccountById(Integer accountId) {
        U.load();
        try {
            return (LoanAccount) U.accountMap.get(accountId);
        } catch (ClassCastException e) {
            return null;
        }
    }

    /**
     * 进行贷款操作
     * @param accountId 要贷款的 id
     * @param amount 要贷款的 金额
     * @return 返回是否贷款成功
     */
    public boolean loan(Integer accountId, double amount, String password) {

        LoanAccount account = selectLoanAccountById(accountId);
        if (account == null) return false;
        if (! password.equals(account.getPassword())) return false;

        boolean deposit = accountService.deposit(accountId, account.getPassword(), amount);
        if (deposit) {
            account.setLoanAmount(amount);
            U.load();
            U.write();
            return true;
        }

        return false;
    }

    /**
     * 还款操作
     * @param accountId 要还款的 用户 id
     * @param amount 要还款的金额
     * @param password 密码
     * @return 返回是否还款成功
     */
    public boolean repayment(Integer accountId, double amount, String password) {
        LoanAccount account = selectLoanAccountById(accountId);
        if (account == null) return false;
        if (! password.equals(account.getPassword())) return false;

        double balance = account.getBalance();
        if (balance > amount) {
            boolean b = accountService.withdrawMoney(accountId, account.getPassword(), amount);
            if (b) {
                account.setLoanAmount(account.getLoanAmount() + amount);
                U.load();
                U.write();
                return true;
            }
        }
        return false;
    }


    /**
     * 查询用户贷款金额
     * @param accountId 要查询的用户 id
     * @return 返回该用户的剩余未还贷款
     */
    public double selectLoanAmount(Integer accountId) {
        LoanAccount loanAccount = selectLoanAccountById(accountId);
        return loanAccount.getLoanAmount();
    }
}
