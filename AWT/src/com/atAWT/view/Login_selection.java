package com.atAWT.view;

import com.atAWT.utils.WindowUtils;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Paths;

/**
 * @author wspstart
 * @create 2022-06-23 18:52
 */
public class Login_selection extends JFrame {
    private JPanel panel1;
    private JButton loanAccountButton;
    private JButton creditAccountButton;
    private JButton storageAccountButton;

    public Login_selection() {
        this.add(panel1);
        storageAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login = new Login(Paths.get("SavingAccount.txt"));
                WindowUtils.openJFrame(login);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
