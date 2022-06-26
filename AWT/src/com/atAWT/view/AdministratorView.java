package com.atAWT.view;

import com.atAWT.SortInformation;
import com.atAWT.model.Account;
import com.atAWT.service.AdministratorService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;

/**
 * @author wspstart
 * @create 2022-06-25 10:13
 */
public class AdministratorView extends JFrame {
    private JButton xxButton;
    private JButton balanceButton;
    private JPanel AdministratorPanel;
    private JButton 查看用户资产排名Button;
    private  AdministratorService administrator = new AdministratorService();
    public AdministratorView() {
        this.add(AdministratorPanel);
        this.setSize(2560,1600);
        this.setVisible(true);
        xxButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Info info = new Info(administrator.getAllAccount());
            }
        });
        balanceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new AllBalance();
            }
        });
        查看用户资产排名Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                LinkedHashMap<Integer, Account> allAccountOrderByBalance = administrator.getAllAccountOrderByBalance();
                new SortInformation(allAccountOrderByBalance);
            }
        });
    }
}
