package com.atAWT.model;

import java.io.Serializable;

/**
 * 贷款账户
 * @author wspstart
 * @create 2022-06-24 10:42
 */
public class LoanAccount extends Account implements Serializable {
    private double loanAmount;//贷款额度

    public LoanAccount(String password, String name, String personID, String tel, double balance, double loanAmount) {
        super(password, name, personID, tel, balance);
        this.loanAmount = loanAmount;
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
