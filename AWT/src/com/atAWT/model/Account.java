package com.atAWT.model;

import com.atAWT.utils.UserID;

import java.io.Serializable;
import java.util.*;

/**
 * 账户
 *
 * @author wspstart
 * @create 2022-06-21 8:50
 */
public class Account implements Serializable {
    private static final long serialVersionUID = 42L;
    private Integer ID = UserID.getID();//账号
    private String password;//密码
    private String name;
    private String personID;//身份证
    private String tel;//联系电话
    private double balance = 0.0;//余额


    public Account(int ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    public Account(String password, String name, String personID, String tel) {
        this.password = password;
        this.name = name;
        this.personID = personID;
        this.tel = tel;
    }

    public Account() {
    }
    public Integer getID() {
        return ID;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Account{" +
                "password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", personID='" + personID + '\'' +
                ", tel='" + tel + '\'' +
                ", balance=" + balance +
                '}';
    }



    /**
     * 存款方式
     *
     * @param money
     */
    public void deposite(double money) {
        if (money <= 0) {
            System.out.println("存款金额不得小于0");
            return;
        }
        balance += money;
    }

    /**
     * 取款金额
     *
     * @param money
     */
    public void withs(double money) {
        if (balance < money) {
            String err = "余额不足！";
            System.out.println("余额不足！");
        }
        balance -= money;
        System.out.println("取款成功！");
    }
}