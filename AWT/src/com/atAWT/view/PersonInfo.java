package com.atAWT.view;

import com.atAWT.model.Account;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-24 17:57
 */
public class PersonInfo extends JFrame{
    private JTextField idtextField1;
    private JTextField pswtextField2;
    private JTextField nametextField3;
    private JTextField personidtextField4;
    private JTextField teltextField5;
    private JTextField balancetextField6;
    private JPanel inofPanel;
    private JButton OkButton;

    public PersonInfo(Account account)  {
        idtextField1.setText(account.getID().toString());
        pswtextField2.setText(account.getPassword());
        nametextField3.setText(account.getName());
        personidtextField4.setText(account.getPersonID());
        teltextField5.setText(account.getTel());
        balancetextField6.setText(String.valueOf(account.getBalance()));
        this.add(inofPanel);
        this.setSize(2560,1600);
        this.setVisible(true);
        OkButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                toClose();
            }
        });
    }

    private void toClose() {
        this.setVisible(false);
    }
}
