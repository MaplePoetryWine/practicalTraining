package com.atAWT.controller;

import com.atAWT.model.Account;
import com.atAWT.model.LoanAccount;
import com.atAWT.model.U;
import org.junit.Test;

public class Main {
    //又一个测试类

    public static void main(String[] args) {
        U.addCount(new LoanAccount("1","1","1","1",1,1));
    }
}
