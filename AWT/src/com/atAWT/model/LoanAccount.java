package com.atAWT.model;

import java.io.Serializable;

/**
 * 贷款账户
 * @author wspstart
 * @create 2022-06-24 10:42
 * @modify: Ding
 * @modifyTime: 2022-06-25
 */
public class LoanAccount extends Account implements Serializable {

    private static final long serialVersionUID = 42L;
    private double loanAmount;//贷款额度

    public LoanAccount() {}

    public LoanAccount(Account account, double loanAmount) {
        this.ID = account.getID();
        this.name = account.getName();
        this.tel = account.getTel();
        this.password = account.getPassword();
        this.balance = account.getBalance();
        this.personID = account.getPersonID();
        this.loanAmount = loanAmount;
    }

    public LoanAccount(String password, String name, String personID, String tel, double loanAmount) {
        super(password, name, personID, tel);
        this.loanAmount = loanAmount;
    }

    public LoanAccount(Account account) {
        this(account, 100000);
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "LoanAccount{" +
                "loanAmount=" + loanAmount +
                "} " + super.toString();
    }
}
