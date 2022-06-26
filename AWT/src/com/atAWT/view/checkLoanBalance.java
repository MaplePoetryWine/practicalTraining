package com.atAWT.view;

import com.atAWT.model.LoanAccount;
import com.atAWT.service.LoanAccountService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.swing.*;

/**
 * @author wspstart
 * @create 2022-06-25 23:21
 */
public class checkLoanBalance extends JFrame {
    private JTextField IDField1;
    private JTextField moneytextField2;
    private JPanel checkPanel;
    private LoanAccountService loanAccountService = new LoanAccountService();

    public checkLoanBalance(LoanAccount account) {
        this.setVisible(true);
        this.add(checkPanel);
        this.setSize(2560,1600);
        IDField1.setText(account.getID().toString());
        moneytextField2.setText(String.valueOf(loanAccountService.selectLoanAmount(account.getID())));
    }
}
