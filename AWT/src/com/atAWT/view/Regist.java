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
public class Regist extends JFrame {

    private JTextField PersonIDField;
    private JTextField nameField2;
    private JTextField telField3;
    private JPasswordField passwordField1;
    private JButton registerNowButton;
    private JPanel RegistPanel;
    private JLabel error;
    private JLabel personIderrorLabel;
    private AccountService accountS = new AccountService();

    /**
     * 判断身份证号是否输入正确
     */
    private boolean personIdIsTrue = false;

    public Regist() {
        this.add(RegistPanel);
        registerNowButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Account account = new Account(passwordField1.getText(), nameField2.getText(), PersonIDField.getText(), telField3.getText());
                if (!personIdIsTrue) {
                    error.setText("请检查身份证号是否输入正确。");
                    return;
                }
                Account register = accountS.register(account);
                if (register == null) {
                    error.setText("注册失败！");
                } else {
                    if (personIderrorLabel.getText().equals("X")) {
                        error.setText("注册失败!身份证号输入错误！");
                    } else {
                        AccountID accountID = new AccountID(account);
                        toClose();
                    }
                }
            }
        });
        this.setSize(2560, 1600);
        this.setVisible(true);
        PersonIDField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                String personIDFieldStr = PersonIDField.getText();
                if (personIDFieldStr.length() == 18 && personIDFieldStr.matches("^\\d+$")) {
                    personIderrorLabel.setText("");
                    personIdIsTrue = true;
                } else if (personIDFieldStr.equals("")) {
                    personIderrorLabel.setText("");
                } else {
                    personIderrorLabel.setText("X");
                }
            }
        });
    }
    private void toClose() {
        this.setVisible(false);
    }
}
