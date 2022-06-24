package com.atAWT.view;

import com.atAWT.model.Account;
import com.atAWT.service.AccountService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-24 16:06
 */
public class Regist extends JFrame{

    private JTextField PersonIDField;
    private JTextField nameField2;
    private JTextField telField3;
    private JPasswordField passwordField1;
    private JButton registerNowButton;
    private JPanel RegistPanel;
    private JLabel error;
    private AccountService accountS = new AccountService();;

    public Regist() {
        this.add(RegistPanel);
        registerNowButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Account account = new Account(passwordField1.getText(), nameField2.getText(), PersonIDField.getText(), telField3.getText());
                Account register = accountS.register(account);
                if (register == null){
                    error.setText("注册失败！！！");
                } else {
                    error.setText(" 您的账号为：" + account.getID().toString());
                }
            }
        });
        this.setSize(500,600);
        this.setLocation(400,500);
        this.setVisible(true);
    }
}
