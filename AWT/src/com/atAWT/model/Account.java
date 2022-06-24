package com.atAWT.model;

import com.atAWT.controller.ReadWriteFile;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.Serializable;
import java.util.*;

/**
 * 账户
 *
 * @author wspstart
 * @create 2022-06-21 8:50
 */
public class Account implements Serializable {
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
            String err = "余额不足！";
            System.out.println("余额不足！");
        }
        balance -= money;
        System.out.println("取款成功！");
    }

    String FILENAME = "src\\LoanAccount.txt";
    String REPACEFILENAME ="src\\LoanAccountcopy.txt";


    /**
     * 由于是替换余额的，本账号的余额要减少，被转号要增加，先写一个文件，存的是本号减少的，然后再 读取这个文件，将转账号的余额增加，所以原文件任为有效文件
     * 转账
     * @param ID 转账的账号
     * @return
     */
    public  boolean transfer(int ID,double money){
        Map<Integer, String> map = ReadWriteFile.Login_AccountFile(FILENAME);
        Set<Integer> keySet = map.keySet();
        for (Integer key: keySet ){
            if (key == ID){
                Map<Integer, Account> integerAccountMap = ReadWriteFile.readTxtFile(FILENAME);
                Set<Integer> integers = integerAccountMap.keySet();
                for (Integer key1 : integers){
                    if (key1 == ID){
                        Account account = integerAccountMap.get(ID);
                        double deleted = getBalance();
                        setBalance(getBalance() - money);
                        ReadWriteFile.replace(FILENAME,REPACEFILENAME,String.valueOf(deleted),2,String.valueOf(getBalance()));
                        ReadWriteFile.replace(REPACEFILENAME,FILENAME,String.valueOf(account.getBalance()),2,String.valueOf((account.getBalance() + money)));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}