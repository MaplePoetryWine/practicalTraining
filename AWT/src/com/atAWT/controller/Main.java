package com.atAWT.controller;

import com.atAWT.model.Account;
import com.atAWT.model.U;
import com.atAWT.utils.WindowUtils;
import com.atAWT.view.Login_selection;
import org.junit.Test;

public class Main {
    //又一个测试类

    public static void main(String[] args) {
    //test01
        WindowUtils.openJFrame(new Login_selection());
    }
    @Test
    public static  void add(){
        Account account = new Account("1","1","1","1",1);
        System.out.println(account.getID());
    }
    public static  void login(){
        Account account = new Account("1","1","1","1",1);
        System.out.println(account.getID());
    }
}
