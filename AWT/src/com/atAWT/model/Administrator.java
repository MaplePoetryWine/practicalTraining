package com.atAWT.model;

import com.atAWT.controller.ReadWriteFile;

import java.util.Map;
import java.util.Set;

/**
 * 管理人员类
 *
 * @author wspstart
 * @create 2022-06-21 9:09
 */
@SuppressWarnings("all")
public class Administrator extends Account {
    private final static String CREDITACCOUNTFILE = "src\\CreditAccount.txt";
    private final static String LOANACCOUNTFILE = "src\\LoanAccount.txt";
    private final static String SAVINGACCOUNT = "src\\SavingAccount.txt";

    /**
     * 管理员查看所有的用户信息
     * 遍历三个txt文件上的内容，后期将其输出在面板上
     */
    public void statistics() {
        //遍历CreaditAccount.txt
        Map<Integer, Account> creditAccounts = ReadWriteFile.readTxtFile(CREDITACCOUNTFILE);
        Set<Integer> credkey = creditAccounts.keySet();
        String str = "ID\t\t\t Name\t\t\tPersonID\t\t\t\ttel\t\t\t\tbalance";
        System.out.println(str);
        for (Integer SetCred : credkey) {
            Account account = creditAccounts.get(SetCred);
            String credit = SetCred + "\t\t" + account.getName() + "\t\t"
                    + account.getPersonID() + "\t\t" + account.getTel() + "\t\t" +
                    account.getBalance();
            System.out.println(credit);
        }
        //遍历LoanAccount.txt
        Map<Integer, Account> loanaccount = ReadWriteFile.readTxtFile(LOANACCOUNTFILE);
        Set<Integer> loankey = loanaccount.keySet();
        for (Integer SetLoan : loankey) {
            Account account = loanaccount.get(SetLoan);
            String loan = SetLoan + "\t\t" + account.getName() + "\t\t"
                    + account.getPersonID() + "\t\t" + account.getTel() + "\t\t" +
                    account.getBalance();
            System.out.println(loan);
        }
        //遍历SavingAccount.txt
        Map<Integer, Account> Savingaccount = ReadWriteFile.readTxtFile(SAVINGACCOUNT);
        Set<Integer> Savingkey = Savingaccount.keySet();
        for (Integer SetSaving : Savingkey) {
            Account account = Savingaccount.get(SetSaving);
            String saving = SetSaving + "\t\t" + account.getName() + "\t\t"
                    + account.getPersonID() + "\t\t" + account.getTel() + "\t\t" +
                    account.getBalance();
            System.out.println(saving);
        }
    }

    /**
     * 该方法用于统计所有的用户总资产
     */
    public void lumpSum() {
        double creditBalance = ReadWriteFile.getBalance(CREDITACCOUNTFILE);
        double loanBalance = ReadWriteFile.getBalance(LOANACCOUNTFILE);
        double savingBalance = ReadWriteFile.getBalance(SAVINGACCOUNT);
        double lumpSum = creditBalance + loanBalance + savingBalance;
        System.out.println(lumpSum);
    }

    public void assetRanking() {
        //获取到CreditAccount.txt的所有
        Map<Integer, Double> creditAccount = ReadWriteFile.getOneBalance(CREDITACCOUNTFILE);
        String type1 = "\t信用账户\t";
        System.out.println(type1);
        String str = "ID \t\t\tBALANCE";
        System.out.println(str);
        Set<Integer> ID = creditAccount.keySet();
        for (Integer id : ID){
            Double aDouble = creditAccount.get(id);
            String asset = id  + "\t\t"+ String.valueOf(aDouble);
            System.out.println(asset);
        }
        //获取到loanAccount.txt
        Map<Integer, Double> loanAccount = ReadWriteFile.getOneBalance(LOANACCOUNTFILE);
        String type2 = "\t贷款账户\t";
        System.out.println(type1);
        System.out.println(str);
        Set<Integer> loanID = loanAccount.keySet();
        for (Integer id : loanID){
            Double aDouble = loanAccount.get(id);
            String asset = id  + "\t\t"+ String.valueOf(aDouble);
            System.out.println(asset);
        }
        //获取到SavingAccount.txt
        Map<Integer, Double> savingAccount = ReadWriteFile.getOneBalance(SAVINGACCOUNT);
        String type3 = "\t储蓄账户\t";
        System.out.println(type3);
        System.out.println(str);
        Set<Integer> savingID = savingAccount.keySet();
        for (Integer id : savingID){
            Double aDouble = savingAccount.get(id);
            String asset = id  + "\t\t"+ String.valueOf(aDouble);
            System.out.println(asset);
        }
    }
}
