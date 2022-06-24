package com.atAWT.dao.impl;

import com.atAWT.utils.ReadWriteFile;

import java.util.Set;

/**
 * @author wspstart
 * @create 2022-06-21 17:49
 */
public class Bank {
    private static final int CREDITACCOUNT = 0;
    private static final int LOANACCOUNT = 1;
    private static final int SAVINGACCOUNT = 2;

    private final static String CREDITACCOUNTFILE = "src\\CreditAccount.txt";
    private final static String LOANACCOUNTFILE = "src\\LoanAccount.txt";
    private final static String SAVINGACCOUNTFILE = "src\\SavingAccount.txt";

    /**
     * 注册判断
     * @param type 注册的类型
     * @return
     */
    public boolean registJudgment(int type){
        switch (type){
            case CREDITACCOUNT:

        }
        return false;
    }
    public boolean registCreditAccount(){
        Set<String> creditAccount = ReadWriteFile.Regist_AccountFile(CREDITACCOUNTFILE);//获取到所有的账户身份证信息
        return false;
    }


    /**
     * 登录
     * @param account
     * @param psw
     * @return
     */
    public boolean logIn(String account,String psw ){

        return false;
    }

    /**
     * 取款
     * @param money
     * @return
     */
    public boolean withdrawMoney(double money){

        return false;
    }

    /**
     * 存款
     * @param money
     * @return
     */
    public boolean deposit(double money){
        return false;
    }
}
