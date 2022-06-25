package com.atAWT.view;

import com.atAWT.service.AdministratorService;

import javax.swing.*;

/**
 * @author wspstart
 * @create 2022-06-25 11:35
 */
public class AllBalance extends JFrame{
    private JTextField allBalancetextField1;
    private JPanel allBalancePanel;
    private AdministratorService administratorService = new AdministratorService();

    public AllBalance() {
       this.add(allBalancePanel);
        double allAccountBalance = administratorService.getAllAccountBalance();
        allBalancetextField1.setText(String.valueOf(allAccountBalance));
        this.setVisible(true);
        this.setSize(2560,1600);
    }
}
