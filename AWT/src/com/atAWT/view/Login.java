package com.atAWT.view;

import com.atAWT.model.Account;
import com.atAWT.service.AccountService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-24 15:44
 */
public class Login extends JFrame {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginbutton;
    private JButton registerbutton;
    private JPanel loginPanel;
    private JLabel prompt;
    private AccountService accountS = new AccountService();

    public Login() {
        this.add(loginPanel);
        this.setTitle("用户登录");
        loginbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String ID = textField1.getText();
                String psw = passwordField1.getText();

                try {
                    if (ID.equals("") || psw.equals("")) {
                        prompt.setText("您还没有正确输入！");
                    }
                    if (ID.equals("root") && psw.equals("56789")) {
                        new AdministratorView();
                    } else {
                        Account isTrue = accountS.login(ID, psw);
                        if (isTrue == null) {
                            prompt.setText("登录失败！！！");
                        } else {
                            prompt.setText("登录成功！！！");
                            Surface surface = new Surface(accountS, isTrue);
                            toClose();
                        }
                    }
                } catch (Exception ex) {
                  ex.printStackTrace();
                }
            }
        });
        this.setSize(2560, 1600);
        this.setVisible(true);
        registerbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Regist regist = new Regist();
            }
        });
    }

    private void toClose() {
        this.setVisible(false);
    }

}
