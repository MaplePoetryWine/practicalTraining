package com.atAWT.dao.impl;

import com.atAWT.model.Account;
import com.atAWT.model.U;
import com.atAWT.dao.AccountDao;

import java.io.*;
import java.util.HashMap;

public class AccountDaoImpl implements AccountDao {

    /**
     * 存放所有用户，用于序列化对象
     */
    public static HashMap<Integer, Account> map = new HashMap<>();

    /**
     * 类加载时自动读取已创建的对象
     */
    static {
        try {
            updateList();
        } catch (EOFException e) {
            System.out.print("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理注册请求
     * @param account 要注册的用户
     * @return 返回是否注册成功
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public boolean register(Account account) throws IOException, ClassNotFoundException {
        updateList();
        map.put(account.getID(), account);
        updateFile();
        return true;
    }

    /**
     * 从 list 中序列化对象到文件中
     * @throws IOException
     */
    private static void updateFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("AWT/src/com/atAWT/model/account.obj"))) {

            oos.writeObject(map.values().toArray(new Account[0]));
            oos.flush();

        } catch (EOFException e) {
            System.out.print("");
        }
    }

    /**
     * 从 文件 中反序列化对象到 list
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void updateList() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AWT/src/com/atAWT/model/account.obj"))) {

            Account[] arr = (Account[]) ois.readObject();
            if (arr != null) {
                for (Account account : arr) {
                    map.put(account.getID(), account);
                }
            }
        } catch (EOFException e) {
            System.out.print("");
        }
    }

    @Override
    public boolean login(Account account) {
        String inPassword = account.getPassword();
        String truePassword = U.accountMap.get(account.getID()).getPassword();
        if(truePassword.equals(inPassword)){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean checkRePassword(String password, String rePassword) {
        return false;
    }

    @Override
    public boolean deposit(Integer accountId, double amount) throws IOException {
        Account account = map.get(accountId);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            updateFile();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean withdrawMoney(Account account, double amount) {
        account.setBalance(account.getBalance() - amount);
        return true;
    }
}
