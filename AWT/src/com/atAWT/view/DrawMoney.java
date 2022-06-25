package com.atAWT.view;

import com.atAWT.model.Account;
import com.atAWT.service.AccountService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-24 21:24
 */
public class DrawMoney extends JFrame {
    private JTextField IDField;
    private JTextField moneyField;
    private JButton OKButton;
    private JPanel drawMoneyPanel;
    private JPasswordField pswtextField1;
    private JLabel error;

    public DrawMoney(AccountService accountService, Account account) {
        this.add(drawMoneyPanel);
        this.setSize(2560, 1600);
        this.setVisible(true);
        OKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //写的代码
                try {
                    Account account_ = accountService.selectById(Integer.parseInt(IDField.getText()));
                    String transfer = accountService.transfer(account.getID(), account_.getID(), Double.parseDouble(moneyField.getText()));
                    error.setText(transfer);
                } catch (NumberFormatException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void toClose() {
        this.setVisible(false);
    }
}
