package com.atAWT.dao;

import com.atAWT.model.Account;

import java.io.IOException;

public interface AccountDao {
    //注册功能
    public boolean register(Account account) throws IOException, ClassNotFoundException;
    public boolean login(Account account);
    public boolean checkRePassword(String password,String rePassword);

    boolean deposit(Integer accountId, double amount) throws IOException;
}
