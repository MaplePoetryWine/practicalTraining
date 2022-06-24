package com.atAWT.dao.impl;

import com.atAWT.model.Account;
import com.atAWT.model.U;
import com.atAWT.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public boolean register(Account account) {
        boolean flag = U.addCount(account);
        return flag;
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
}
