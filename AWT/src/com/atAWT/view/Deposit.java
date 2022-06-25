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
    private JPasswordField pswtextField2;
    private JButton OKButton;
    private JPanel DepositPanel;
    private JLabel error;
    private AccountService accountService = new AccountService();
    public Deposit(Account account) {
        this.add(DepositPanel);
        this.setSize(2560,1600);
        this.setVisible(true);
        OKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean deposit = accountService.deposit(account.getID(),pswtextField2.getText(),Double.parseDouble(moneytextField1.getText()) );
                if ( !deposit ){
                    error.setText("存款失败！");
                }else{
                    error.setText("存款成功！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    toClose();
                }
            }
        });
    }

    private void toClose() {
        this.setVisible(false);
    }
}
