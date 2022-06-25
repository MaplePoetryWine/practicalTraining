package com.atAWT.view;

import com.atAWT.model.Account;
import com.atAWT.service.AccountService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-24 21:57
 */
public class BalanceView extends JFrame {
    private JTextField IDtextField1;
    private JTextField BalancetextField2;
    private JButton OKButton;
    private JPanel BalancePanel;
    private AccountService accountService = new AccountService();

    public BalanceView(Account account) {
        this.add(BalancePanel);
        this.setSize(2560,1600);
        this.setVisible(true);
        IDtextField1.setText(account.getID().toString());
        double balanceById = accountService.getBalanceById(account.getID());
        BalancetextField2.setText(String.valueOf(balanceById));
        OKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                toClose();
            }
        });
    }

    private void toClose() {
        this.setVisible(false);
    }
}
