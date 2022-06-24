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
    private  AccountService accountS  = new AccountService();
    public Login() {
        this.add(loginPanel);
        loginbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Account isTrue = accountS.login(textField1.getText(), passwordField1.getText());
                if (isTrue == null){
                    prompt.setText("登录失败！！！");
                }else {
                    prompt.setText("登录成功！！！");
                    Surface surface = new Surface(isTrue);
                }
            }
        });
        this.setSize(500, 400);
        this.setLocation(400,500);
        this.setVisible(true);
        registerbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Regist regist = new Regist();
            }
        });
    }

}
