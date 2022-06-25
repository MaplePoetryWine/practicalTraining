package com.atAWT.service;

import com.atAWT.dao.impl.SavingAccountDao;
import com.atAWT.model.U;
import com.atAWT.model.SavingAccount;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wspstart
 * @create 2022-06-24 12:43
 */
@SuppressWarnings("all")
public class SavingAccountService {

    private static Lock lock = new ReentrantLock();

//    private SavingAccount savingAccount;
//    String FILENAME = "src\\SavingAccount.txt";
//    String REPACEFILENAME ="src\\SavingAccountcopy.txt";
//    /**
//     * 由于是替换余额的，本账号的余额要减少，被转号要增加，先写一个文件，存的是本号减少的，然后再 读取这个文件，将转账号的余额增加，所以原文件任为有效文件
//     * 转账
//     * @param ID 转账的账号
//     * @return
//     */
//    public  boolean transfer(int ID,double money){
//        Map<Integer, String> map = ReadWriteFile.Login_AccountFile(FILENAME);
//        Set<Integer> keySet = map.keySet();
//        for (Integer key: keySet ){
//            if (key == ID){
//                Map<Integer, Account> integerAccountMap = ReadWriteFile.readTxtFile(FILENAME);
//                Set<Integer> integers = integerAccountMap.keySet();
//                for (Integer key1 : integers){
//                    if (key1 == ID){
//                        Account account = integerAccountMap.get(ID);
//                        double deleted = savingAccount.getBalance();
//                        savingAccount.setBalance(savingAccount.getBalance() - money);
//                        ReadWriteFile.replace(FILENAME,REPACEFILENAME,String.valueOf(deleted),2,String.valueOf(savingAccount.getBalance()));
//                        ReadWriteFile.replace(REPACEFILENAME,FILENAME,String.valueOf(account.getBalance()),2,String.valueOf((account.getBalance() + money)));
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }

    /**
     * 处理转账请求
     * @param payId 转账用户的 savings 账户 id
     * @param payeeId 收款者 savings 账户 id
     * @param amount 要转账的金额
     * @return 返回 "true" 表示转账成功 ；若转账失败，则返回格式为： "error: 错误提示信息"；如："error: 当前用户不存在" ，或者："error: 用户余额不足"
     */
    public String transfer(Integer payId, Integer payeeId, double amount) {
        lock.lock();
        SavingAccount payAccount = SavingAccountDao.map.get(payId);
        SavingAccount payeeAccount = U.savingMap.get(payeeId);

        // 用户可能不存在
        if (payAccount == null) {
            return "error: 当前用户不存在";
        }
        if (payeeAccount == null) {
            return "error: 收款用户不存在";
        }

        // 备份用户余额，用于回滚
        double payBalance = payAccount.getBalance();
        double payeeBalance = payeeAccount.getBalance();
        try {

            // 用户余额不足以转账
            if (payAccount.getBalance() - amount < 0) {
                return "error: 用户余额不足";
            }

            payAccount.setBalance(payAccount.getBalance() - amount);
            payeeAccount.setBalance(payAccount.getBalance() + amount);

            return "true";
        } catch (Exception e) {
            if (payAccount.getBalance() != payBalance) {
                payAccount.setBalance(payBalance);
                U.savingMap.put(payId, payAccount);
            }
            if (payeeAccount.getBalance() != payeeBalance) {
                payeeAccount.setBalance(payeeBalance);
                U.savingMap.put(payeeId, payeeAccount);
            }
            return "error: 系统异常！转账失败";
        } finally {
            U.write();
            lock.unlock();
        }
    }

    /**
     * 进行存款操作
     * @param account 要存款的用户的 savings账户id
     * @param amount 要存款的金额
     */
    public void deposit(Integer account, double amount) {
        try {
            lock.lock();
            SavingAccount savingAccount = U.savingMap.get(account);
            savingAccount.setBalance(savingAccount.getBalance() + account);

        } finally {
            lock.unlock();
            U.write();
        }

    }

    /**
     * 处理取款操作
     * @param account 要进行取款的 用户 id
     * @param amount 要取款的金额
     * @return 返回 "true" 表示取款成功；若取款失败，则返回格式为： "error: 错误提示信息"；如："error: 当前用户不存在" ，或者："error: 用户余额不足"
     */
    public String withdrawMoney(Integer account, double amount) {
        SavingAccount savingAccount = U.savingMap.get(account);
        if (savingAccount == null) {
            return "error: 当前用户不存在";
        }
        double balance = savingAccount.getBalance();
        try {
            lock.lock();

            double newBalance = savingAccount.getBalance() - account;
            if (newBalance > 0) {
                savingAccount.setBalance(newBalance);
                return "true";
            } else {
                return "error: 用户余额不足";
            }
        } catch (Exception e) {
            if (savingAccount.getBalance() != balance) {
                savingAccount.setBalance(balance);
                U.savingMap.put(account, savingAccount);
            }
            return "系统异常，取款失败";
        } finally {
            lock.unlock();
            U.write();
        }

    }
}
