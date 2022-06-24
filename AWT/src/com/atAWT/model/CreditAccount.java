package com.atAWT.model;

import java.io.Serializable;

/**
 * 子账户  信用账户
 * @author wspstart
 * @create 2022-06-21 9:08
 */
public class CreditAccount extends Account implements Serializable {
    private double ceiling;//信用额度(可设置透支金额)

    public CreditAccount() {
    }

    public CreditAccount(double ceiling) {
        this.ceiling = ceiling;
    }

    public CreditAccount( String password,  String name, String personID, String tel, double balance) {
        super( password, name, personID, tel, balance);
    }

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        if(ceiling >= 10000){
            String str = "信誉额度不够,不能设置过多的透支金额哦！";
            return;
        }
        this.ceiling = ceiling;
    }

    /**
     * 信用账户取款
     * @param money
     */
    public void withdraw(double money){
        if (getBalance() + ceiling < money){
            String err = "信用额+余额不足！！！";
            System.out.println("信用额+余额不足！！！");
            return;
        }
        setBalance(getBalance() - money);
        System.out.println("取款成功！！！");
    }
}
