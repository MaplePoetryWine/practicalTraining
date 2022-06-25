package com.atAWT.view;

import com.atAWT.model.Account;

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

    public BalanceView(Account account) {
        this.add(BalancePanel);
        this.setSize(2560,1600);
        this.setVisible(true);
        IDtextField1.setText(account.getID().toString());
        BalancetextField2.setText(String.valueOf(account.getBalance()));
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
