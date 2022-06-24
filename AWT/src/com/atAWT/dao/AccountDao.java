package com.atAWT.dao;

import com.atAWT.model.Account;

public interface AccountDao {
    //注册功能
    public boolean register(Account account);
    public boolean login(Account account);
    public boolean checkRePassword(String password,String rePassword);
}
