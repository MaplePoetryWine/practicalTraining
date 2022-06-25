package com.atAWT.model;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import java.io.Serializable;

/**
 * 子账户  信用账户
 * @author wspstart
 * @create 2022-06-21 9:08
 */
public class CreditAccount extends Account implements Serializable {

    private static final long serialVersionUID = 42L;

    private double ceiling;//信用额度(可设置透支金额)

    public CreditAccount( String password,  String name, String personID, String tel) {
        super( password, name, personID, tel);
    }

    public double getCeiling() {
        return ceiling;
    }

}
