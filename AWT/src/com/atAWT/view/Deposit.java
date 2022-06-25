package com.atAWT.view;

import com.atAWT.model.Account;
import com.atAWT.service.AccountService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-24 23:35
 */
public class Deposit extends JFrame{
    private JTextField moneytextField1;
    private JTextField pswtextField2;
    private JButton OKButton;
    private JPanel DepositPanel;
    private JLabel error;
    private AccountService accountService = new AccountService();
    public Deposit(Account account) {
        this.add(DepositPanel);
        this.setSize(400,300);
        this.setVisible(true);
        OKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean deposit = accountService.deposit(account.getID(), Double.parseDouble(moneytextField1.getText()));
                if ( !deposit ){
                    error.setText("存款失败！");
                }else{
                    error.setText("存款成功！");
                    toClose();
                }
            }
        });
    }

    private void toClose() {
        this.setVisible(false);
    }
}
