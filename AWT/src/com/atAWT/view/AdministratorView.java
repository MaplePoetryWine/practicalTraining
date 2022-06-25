package com.atAWT.view;

import com.atAWT.service.AdministratorService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-25 10:13
 */
public class AdministratorView extends JFrame {
    private JButton xxButton;
    private JButton balanceButton;
    private JPanel AdministratorPanel;
    private  AdministratorService administrator = new AdministratorService();
    public AdministratorView() {
        this.add(AdministratorPanel);
        this.setSize(400,350);
        this.setVisible(true);
        xxButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Info info = new Info(administrator.getAllAccount());
            }
        });
    }
}
