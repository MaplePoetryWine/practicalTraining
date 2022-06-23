package com.atAWT.view;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 登录注册界面
 * @author wspstart
 * @create 2022-06-22 11:57
 */
public class Login {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton 登录Button;
    private JButton 注册Button;
    private JButton 找回密码Button;
    private JLabel errorMeg;

    public Login() {
        登录Button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println("登录成功！");
            }
        });
        注册Button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                System.out.println("注册成功！！！");
            }
        });
    }
}
