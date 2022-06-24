package com.atAWT.Test;

import com.atAWT.controller.ReadWriteFile;
import com.atAWT.model.Account;
import com.atAWT.service.Administrator;
import org.junit.Test;

/**
 * @author wspstart
 * @create 2022-06-23 10:41
 */
public class TestReadWriteFile {
    public static final String Account_FILENAME ="AWT\\src\\CreditAccount.txt";
    public static final String Account1_FILENAME ="AWT\\src\\Account1.txt";

    public static void main(String[] args) {
//        Map<Integer, Account> map = ReadWriteFile.readTxtFile(Account_FILENAME);
//        System.out.println(map);
////        System.out.println(map);
//        System.out.println(ReadWriteFile.Login_AccountFile(Account_FILENAME));
//        System.out.println(ReadWriteFile.Regist_AccountFile(Account_FILENAME));
//        ReadWriteFile.replace(Account_FILENAME,Account1_FILENAME,"320721200111153645","9999999999991");
        Account account = new Account("1234567", "王善鹏", "320721200222130819", "lyggwsp@163.com", 90909090);
        ReadWriteFile.Regist_writeFile(Account_FILENAME,account);
//        Account account1 = new Account();
//        while (true){
//            System.out.println(account1.getID());
//        }
    }

    @Test
    public void test(){
        Account account = new Account();
        boolean transfer = account.transfer(10007, 999);
        if (transfer){
            System.out.println("修改成功！！！");
        }else {
            System.out.println("修改失败！！！");
        }
    }
    @Test
    public void test_assetRanking(){
        new Administrator().assetRanking();
    }
}
