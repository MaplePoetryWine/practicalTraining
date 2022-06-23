package com.atAWT.controller;

import com.atAWT.model.Account;

import java.io.*;
import java.util.*;

/**
 * 该类用来读取和存放配置文件的信息
 *
 * @author wspstart
 * @create 2022-06-23 10:09
 */
@SuppressWarnings("all")
public class ReadWriteFile {
    //test注释
    /**
     * 读取txt文件中的全部个人信息读取到内存上然后添加到Map中
     * 用Hashtable的原因是不能存放null值
     *
     * @param fileName
     * @return
     */
    public static Map<Integer, Account> readTxtFile(String fileName) {
        Map<Integer, Account> content = new Hashtable<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String data;
            while ((data = br.readLine()) != null) {
                String[] split = data.split("=");
                content.put(Integer.valueOf(split[0]), new Account(split[1], split[2], split[3],
                        split[4], Double.parseDouble(split[5])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return content;
    }

    /**
     * 读取配置文件中的账号和密码用于模拟登录
     *
     * @param fileName
     * @return
     */
    public static Map<Integer, String> Login_AccountFile(String fileName) {
        Map<Integer, String> map = new Hashtable<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String data;
            while ((data = br.readLine()) != null) {
                String[] split = data.split("=");
                map.put(Integer.valueOf(split[0]), split[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return map;
    }

    /**
     * 用来读取配置文件中的所有的身份证信息，以便在注册过程中验证该身份证是否注册过。
     * 用TreeSet的原因是不能存放null值
     *
     * @param fileName
     * @return
     */
    public static Set<String> Regist_AccountFile(String fileName) {
        Set<String> set = new TreeSet<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String data;
            while ((data = br.readLine()) != null) {
                String[] split = data.split("=");
                set.add(split[3]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return set;
    }

    /**
     * 将Account存入到配置文件中
     *
     * @param fileName
     * @param account
     */
    public static void Regist_writeFile(String fileName, Account account) {
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(fileName, true));
            osw.write("\n" + account.getID() + "=" + account.getPassword() + "=" + account.getName() + "=" +
                    account.getPersonID() + "=" + account.getTel() + "=" + account.getBalance());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                osw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * @param fileName 修改文件的路径
     * @param deleted  被修改的内容
     * @param delete   修改后的内容
     */
    public static void replace(String fileName, String replaceFileName, String deleted, String delete) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            bw = new BufferedWriter(new FileWriter(replaceFileName));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(deleted))
                    line = line.replace(deleted, delete);
                bw.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
