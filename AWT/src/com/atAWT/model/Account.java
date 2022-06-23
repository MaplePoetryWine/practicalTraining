package com.atAWT.model;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 账户
 *
 * @author wspstart
 * @create 2022-06-21 8:50
 */
public class Account {
    public int ID = 0;//账号
    private String password;//密码
    private String name;
    private String personID;//身份证
    private String tel;//联系电话
    private double balance;//余额
    private static List<Integer> list = new ArrayList<>();
    private static int total = 0;

    public Account() {

    }

    public Account(String password, String name, String personID, String tel, double balance) {
        this.password = password;
        this.name = name;
        this.personID = personID;
        this.tel = tel;
        this.balance = balance;
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
     *
     */
    static {
        for (int i = 10007; i <= 999999; i++)
            list.add(i);
    }

    public int getID() {
        ID = list.get(total++);
        if (total >= 98991 ){
            System.out.println("error: total数过大，不能继续添加用户了！！！");
            System.exit(0);
        }
        return ID;
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
            System.out.println("余额不足！");
        }
        balance -= money;
        System.out.println("取款成功！");
    }

}