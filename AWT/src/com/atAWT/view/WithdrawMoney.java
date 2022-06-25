package com.atAWT.view;

import com.atAWT.model.Account;
import com.atAWT.service.AccountService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-24 22:16
 */
public class WithdrawMoney extends JFrame {
    private JTextField MoneytextField1;
    private JPasswordField pswtextField2;
    private JButton OKButton;
    private JPanel withdrawMoney;
    private JLabel error;
    private AccountService accountService = new AccountService();

    public WithdrawMoney(Account account) {
        this.add(withdrawMoney);
        this.setSize(2560, 1600);
        this.setVisible(true);
        OKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (accountService.withdrawMoney(account.getID(), pswtextField2.getText(),
                        Double.parseDouble(MoneytextField1.getText()))) {
                    error.setText("取款成功！！！");
                } else {
                    error.setText("余额不足！！！");
                }
            }
        });
    }
}
