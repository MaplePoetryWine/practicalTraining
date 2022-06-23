package com.atAWT.model;

/**
 * 子账户  信用账户
 * @author wspstart
 * @create 2022-06-21 9:08
 */
public class CreditAccount extends Account{
    private double ceiling;//信用额度

    public CreditAccount() {
    }

    public CreditAccount(double ceiling) {
        this.ceiling = ceiling;
    }

    public CreditAccount( String password, String confirmpassword, String name, String personID, String tel, double balance) {
        super( password, name, personID, tel, balance);
    }

    /**信用账户取款
     * @param money
     */
    public void withdraw(double money){
        if (getBalance() + ceiling < money){
            System.out.println("信用额+余额不足！！！");
            return;
        }
        setBalance(getBalance() - money);
    }
}
