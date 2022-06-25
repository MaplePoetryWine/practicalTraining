package com.atAWT.view;

import com.atAWT.model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-25 14:31
 */
public class AccountID extends JFrame{
    private JTextField IDField1;
    private JPanel AccountIDPanle;
    private JButton OKButton;

    public AccountID() {
        this.add(AccountIDPanle);
        this.setVisible(true);
        this.setSize(2560,1600);
    }

    public AccountID(Account account) {
        this();
        IDField1.setText(account.getID().toString());
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
