package com.atAWT.model;

import java.io.*;
import java.util.HashMap;

/*
    对象序列化存储工具类
    数据持续层替代方案
 */
public class U implements Serializable {
    final static private String PATH = "AWT/src/com/atAWT/model/";
    final static private String C = "credit.obj";
    final static private String L = "loan.obj";
    final static private String S = "saving.obj";
    final static private String A = "account.obj";
    static public HashMap<Integer, CreditAccount> creditMap = new HashMap<>();
    static public HashMap<Integer, SavingAccount> savingMap = new HashMap<>();
    static public HashMap<Integer, LoanAccount> loanMap = new HashMap<>();
    static public HashMap<Integer, Account> accountMap = new HashMap<>();
    //静态加载各种Map对象
    static{
        ObjectInputStream oic = null;
        ObjectInputStream oil = null;
        ObjectInputStream ois = null;
        ObjectInputStream oia = null;
        try {
            oic = new ObjectInputStream(
                    new FileInputStream(PATH + C)
            );
            oil = new ObjectInputStream(
                    new FileInputStream(PATH + L)
            );
            ois = new ObjectInputStream(
                    new FileInputStream(PATH + S)
            );
            oia = new ObjectInputStream(
                    new FileInputStream(PATH + A)
            );
        }catch (Exception e){
            System.out.println("model中不存在对应的.obj文件");
        }
        try {
            creditMap = (HashMap<Integer, CreditAccount>) oic.readObject();
            savingMap = (HashMap<Integer, SavingAccount>) ois.readObject();
            loanMap = (HashMap<Integer, LoanAccount>)oil.readObject();
            accountMap = (HashMap<Integer, Account>)oia.readObject();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("对象读取失败");
            writeObjError();
        }finally {
            System.out.println("finally代码被执行");
            try {
                oic.close();
                oil.close();
                ois.close();
                oia.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /*
    该方法用于存储账户,保证了内存map对象和硬盘map对象信息的一致性
     */
    public static boolean addCount(Account account){
        int start = accountMap.size();
        accountMap.put(account.getID(),account);
        if(account.getClass() == LoanAccount.class){
            loanMap.put(account.getID(),(LoanAccount) account);
        }else if(account.getClass() == CreditAccount.class){
            creditMap.put(account.getID(),(CreditAccount) account);
        }else if(account.getClass() == SavingAccount.class){
            savingMap.put(account.getID(),(SavingAccount) account);
        }
        writeAccount();
        int end = accountMap.size();
        return end - start == 1 ? true : false;
    }
    public static void writeObjError(){
        try{
            //写入cre
            ObjectOutputStream ooc = new ObjectOutputStream(
                    new FileOutputStream(PATH + C)
            );
            ooc.writeObject(new HashMap<Integer, CreditAccount>());
            ooc.close();
            //写入loan
            ObjectOutputStream ool = new ObjectOutputStream(
                    new FileOutputStream(PATH + L)
            );
            ool.writeObject(new HashMap<Integer, LoanAccount>());
            ool.close();
            //写入sav
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(PATH + S)
            );
            oos.writeObject(new HashMap<Integer, SavingAccount>());
            oos.close();
            //写入account
            ObjectOutputStream ooa = new ObjectOutputStream(
                    new FileOutputStream(PATH + A)
            );
            ooa.writeObject(new HashMap<Integer, Account>());
            ooa.close();
        }catch (Exception e){
            System.out.println("对象文件不存在");
            e.printStackTrace();
        }
    }
    public static void writeAccount(){
        ObjectOutputStream oos = null;
        ObjectOutputStream ooc = null;
        ObjectOutputStream ooa = null;
        ObjectOutputStream ool = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(PATH + S));
            oos.writeObject(savingMap);
            ooc = new ObjectOutputStream(new FileOutputStream(PATH + C));
            ooc.writeObject(creditMap);
            ooa = new ObjectOutputStream(new FileOutputStream(PATH + C));
            ooa.writeObject(accountMap);
            ool = new ObjectOutputStream(new FileOutputStream(PATH + L));
            ool.writeObject(loanMap);
        }catch (Exception e){
            System.out.println("writeAccount方法异常");
            e.printStackTrace();
        }finally {
            try{
                oos.close();
                ooa.close();
                ool.close();
                ooc.close();
            }catch (Exception e){
                System.out.println("流对象关闭失败");
                e.printStackTrace();
            }
        }

    }

}
