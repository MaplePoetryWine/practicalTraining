package com.atAWT.controller;

import com.atAWT.model.Account;
import com.atAWT.model.U;
import org.junit.Test;

public class Main {
    //又一个测试类

    public static void main(String[] args) {

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
