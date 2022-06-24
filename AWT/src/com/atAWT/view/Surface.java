package com.atAWT.view;

import com.atAWT.model.Account;
import com.atAWT.service.AccountService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-24 15:53
 */
public class Surface extends JFrame{
    private JButton depositButton;
    private JButton loanButton;
    private JButton withdrawalButton;
    private JButton TransferButton;
    private JButton viewPersonalInformationButton;
    private JButton modifyPersonalInformationButton;
    private JButton checkBalanceButton;
    private JPanel surface;


    public Surface(AccountService accountService,Account account) {
        this.add(surface);
        checkBalanceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        this.setSize(400,600);
        this.setLocation(500,600);
        this.setVisible(true);
        viewPersonalInformationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PersonInfo personInfo = new PersonInfo(account);
            }
        });
        modifyPersonalInformationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                revisePersonInfo revisePersonInfo = new revisePersonInfo(account);
            }
        });
        TransferButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DrawMoney drawMoney = new DrawMoney(accountService, account);
            }
        });
        withdrawalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WithdrawMoney withdrawMoney = new WithdrawMoney(account);
            }
        });
        checkBalanceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                BalanceView balanceView = new BalanceView(account);
            }
        });
        depositButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Deposit deposit = new Deposit(account);
            }
        });
    }
}
