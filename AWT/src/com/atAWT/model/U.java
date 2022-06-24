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
    final static private String A = "administrator.obj";
    final static private String S = "saving.obj";
    static public HashMap<Integer, CreditAccount> creditMap = new HashMap<>();
    static public HashMap<Integer, SavingAccount> savingMap = new HashMap<>();
    static public HashMap<Integer, Administrator> admMap = new HashMap<>();
    //静态加载各种Map对象
    static{
        ObjectInputStream oic = null;
        ObjectInputStream oia = null;
        ObjectInputStream ois = null;
        try {
            oic = new ObjectInputStream(
                    new FileInputStream(PATH + C)
            );
            oia = new ObjectInputStream(
                    new FileInputStream(PATH + A)
            );
            ois = new ObjectInputStream(
                    new FileInputStream(PATH + S)
            );
        }catch (Exception e){
            System.out.println("model中不存在对应的.obj文件");
        }
        try {
            creditMap = (HashMap<Integer, CreditAccount>) oic.readObject();
            savingMap = (HashMap<Integer, SavingAccount>) ois.readObject();
            admMap = (HashMap<Integer, Administrator>) oia.readObject();
        }catch (Exception e){
            System.out.println("对象读取失败");
            writeObjError();
        }finally {
            System.out.println("finally代码被执行");
            try {
                oic.close();
                oia.close();
                ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean addCount(){
        admMap.put(1,new Administrator());
        System.out.println(admMap.size());
        return false;
    }
    public static void writeObjError(){
        try{
            //写入cre
            ObjectOutputStream ooc = new ObjectOutputStream(
                    new FileOutputStream(PATH+C)
            );
            ooc.writeObject(new HashMap<Integer, CreditAccount>());
            ooc.close();
            //写入adm
            ObjectOutputStream ooa = new ObjectOutputStream(
                    new FileOutputStream(PATH+A)
            );
            ooa.writeObject(new HashMap<Integer, Administrator>());
            ooa.close();
            //写入sav
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(PATH+S)
            );
            oos.writeObject(new HashMap<Integer, SavingAccount>());
            oos.close();
        }catch (Exception e){
            System.out.println("对象文件不存在");
            e.printStackTrace();
        }
    }

}
