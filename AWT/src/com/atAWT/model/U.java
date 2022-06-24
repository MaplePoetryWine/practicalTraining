package com.atAWT.model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;

/*
    对象序列化存储工具类
    数据持续层替代方案
 */
public class U implements Serializable {
    static public HashMap<Integer, CreditAccount> creditMap = new HashMap<>();
    static public HashMap<Integer, SavingAccount> savingMap = new HashMap<>();
    static public HashMap<Integer, Administrator> admMap = new HashMap<>();
    //静态加载各种Map对象
    static{
        String path = "src/com/atAWT/model/";
        String c = "credit.obj";
        String a = "administrator.obj";
        String s = "saving.obj";
        ObjectInputStream oic = null;
        ObjectInputStream oia = null;
        ObjectInputStream ois = null;
        try {
            oic = new ObjectInputStream(
                    new FileInputStream(path + c)
            );
            oia = new ObjectInputStream(
                    new FileInputStream(path + a)
            );
            ois = new ObjectInputStream(
                    new FileInputStream(path + s)
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
        }
    }

}
