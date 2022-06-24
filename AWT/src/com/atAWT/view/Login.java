package com.atAWT.view;

import com.atAWT.model.Account;
import com.atAWT.service.AccountService;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

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
    private  AccountService account  = new AccountService();
    public Login() {
        this.add(loginPanel);
        loginbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                account.login(textField1.getText(), passwordField1.getText());
            }
        });
        this.setSize(500, 400);
        this.setLocation(400,500);
        this.setVisible(true);
        registerbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                account.register()
            }
        });
    }

}
