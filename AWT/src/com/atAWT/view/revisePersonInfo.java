package com.atAWT.view;

import com.atAWT.model.Account;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JButton 确定Button;

    public revisePersonInfo(Account account){
        pswtextField.setText(account.getPassword());
        nametextField.setText(account.getName());
        teltextField.setText(account.getTel());
        balancetextField.setText(String.valueOf(account.getBalance()));
//
        this.add(revisePersonInfoPanel);
        this.setSize(400,600);
        this.setVisible(true);

        确定Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                    if (! balancetextField2.getText().equals("")){
                        account.setBalance(Double.parseDouble(balancetextField2.getText()));
                    }else{
                        account.setBalance(Double.parseDouble(balancetextField.getText()));
                    }
                    if (! pswtextField2.getText().equals("")){
                        account.setPassword(pswtextField2.getText());
                    }else {
                        account.setPassword(pswtextField.getText());
                    }
                    if (!nametextField2.getText().equals("")){
                        account.setName(nametextField2.getText());
                    }else {
                        account.setName(nametextField.getText());
                    }
                    if (!teltextField2.getText().equals("")){
                        account.setTel(teltextField2.getText());
                    }else {
                        account.setTel(teltextField.getText());
                    }
            }
        });
    }
}
