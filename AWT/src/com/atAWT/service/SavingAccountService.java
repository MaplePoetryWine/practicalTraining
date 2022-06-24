package com.atAWT.service;

import com.atAWT.controller.ReadWriteFile;
import com.atAWT.model.Account;
import com.atAWT.model.SavingAccount;

import java.util.Map;
import java.util.Set;

/**
 * @author wspstart
 * @create 2022-06-24 12:43
 */
public class SavingAccountService {
    private SavingAccount savingAccount;
    String FILENAME = "src\\SavingAccount.txt";
    String REPACEFILENAME ="src\\SavingAccountcopy.txt";
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
                        double deleted = savingAccount.getBalance();
                        savingAccount.setBalance(savingAccount.getBalance() - money);
                        ReadWriteFile.replace(FILENAME,REPACEFILENAME,String.valueOf(deleted),2,String.valueOf(savingAccount.getBalance()));
                        ReadWriteFile.replace(REPACEFILENAME,FILENAME,String.valueOf(account.getBalance()),2,String.valueOf((account.getBalance() + money)));
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
