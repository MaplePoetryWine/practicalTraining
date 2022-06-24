package com.atAWT.view;

import com.atAWT.model.Account;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author wspstart
 * @create 2022-06-24 18:42
 */
public class revisePersonInfo extends JFrame {
    private JTextField pswtextField;
    private JTextField nametextField;
    private JTextField teltextField;
    private JTextField balancetextField;
    private JTextField pswtextField2;
    private JTextField nametextField2;
    private JTextField teltextField2;
    private JTextField balancetextField2;
    private JLabel error;
    private JPanel revisePersonInfoPanel;

    public revisePersonInfo(Account account){
        pswtextField.setText(account.getPassword());
        nametextField.setText(account.getName());
        teltextField.setText(account.getTel());
        balancetextField.setText(String.valueOf(account.getBalance()));
        this.add(revisePersonInfoPanel);
        this.setSize(400,600);
        this.setVisible(true);
        pswtextField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                try {
                    account.setBalance(Double.parseDouble(balancetextField2.getText()));
                    account.setPassword(pswtextField2.getText());
                    account.setName(nametextField2.getText());
                    account.setTel(teltextField2.getText());
                }catch (Exception ex){
                    System.out.println("存在空文本框");
                    ex.printStackTrace();
                }


            }
        });
    }
}
