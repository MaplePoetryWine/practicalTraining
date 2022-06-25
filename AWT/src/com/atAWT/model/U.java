package com.atAWT.model;

import java.io.*;
import java.util.HashMap;

/**
 * 27148
 * 2022/6/25
 */
/*
    对象序列化存储工具类
    数据持续层替代方案
 */
public class U implements Serializable {
    static public Account loginAccount = null;
    static public HashMap<Integer, CreditAccount> creditMap = new HashMap<>();
    static public HashMap<Integer, SavingAccount> savingMap = new HashMap<>();
    static public HashMap<Integer, LoanAccount> loanMap = new HashMap<>();
    static public HashMap<Integer, Account> accountMap = new HashMap<>();
    final static private String A = "Account.obj";
    /**
     将文件中对象反序列化至HashMap
     */
    final static public void load(){
        //创建文件对象数组
        File file = new File(A);
        createFile(file);
        read(file);
    }

    /**
     * 用于在文件不存在时创建文件
     * @param file
     */
    private final static void createFile(File file){
        if(!file.exists()){
            try {
                file.createNewFile();
                writeError();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 将文件中数组对象装载至HashMap
     * @param files
     */
    final static public void read(File... files){
        for(File file : files){
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
                Account[] arr = (Account[])ois.readObject();
                for(Account account : arr){
                    if (LoanAccount.class == account.getClass())
                        loanMap.put(account.getID(), (LoanAccount) account);
                    else if (CreditAccount.class==account.getClass())
                        creditMap.put(account.getID(), (CreditAccount) account);
                    else if (SavingAccount.class==account.getClass())
                        savingMap.put(account.getID(), (SavingAccount) account);

                    accountMap.put(account.getID(),account);
                }
            } catch (Exception e) {
                System.out.println("不想纠错了,在U里面的read方法");
                write();
                throw new RuntimeException(e);
            } finally {
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    //静态加载各种Map对象
    static{
        load();
    }
    public final static void writeError(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(A));
            Account[] arr = {new Account("1","测试用户","1","1")};
            oos.writeObject(arr);
            oos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*
    该方法用于存储账户,保证了内存map对象和硬盘map对象信息的一致性
     */
    public final static void write(){
        Account[] accounts = new Account[accountMap.size()];
        ObjectOutputStream oos = null;
        int i = 0;
        for (Account account : accountMap.values()){
                accounts[i++] = account;
        }
        try {
            oos = new ObjectOutputStream(new FileOutputStream(A));
            oos.writeObject(accounts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public final static void addAccount(Account account){
        accountMap.put(account.getID(),account);
        write();
    }
}
