package com.atAWT.model;

import java.io.Serializable;

/**
 * 子账户  储蓄账户
 * @author wspstart
 * @create 2022-06-21 17:43
 */
public class SavingAccount extends  Account implements Serializable {
    private final static  long serialVersionUID = 4223114344L;
    public SavingAccount(String password, String name, String personID, String tel) {
        super(password, name, personID, tel);
    }
}
