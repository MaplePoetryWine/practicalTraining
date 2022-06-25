package com.atAWT.view;

import com.atAWT.model.Account;
import com.atAWT.model.LoanAccount;
import com.atAWT.service.AccountService;
import com.atAWT.service.LoanAccountService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-24 15:53
 */
public class Surface extends JFrame{
    private JButton depositButton;
    private JButton withdrawalButton;
    private JButton TransferButton;
    private JButton viewPersonalInformationButton;
    private JButton modifyPersonalInformationButton;
    private JButton checkBalanceButton;
    private JPanel surface;
    private JButton loanButton;
    private JButton repaymentButton;
    private LoanAccountService loanAccountService = new LoanAccountService();

    public Surface(AccountService accountService,Account account) {
        this.add(surface);
        checkBalanceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        this.setSize(2560,1600);

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
        loanButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                LoanAccount loanAccount = loanAccountService.openLoanAccount(account.getID());
                if (loanAccount == null){
                    loan loan = new loan(loanAccountService.selectLoanAccountById(account.getID()));
                }else {
                    loanEligibility loanEligibility = new loanEligibility();
                }

            }
        });
        repaymentButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //还款
            }
        });
    }
}
