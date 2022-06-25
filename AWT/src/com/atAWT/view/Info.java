package com.atAWT.view;

import com.atAWT.model.Account;

import javax.swing.*;
import java.util.Collection;

/**
 * @author wspstart
 * @create 2022-06-25 10:21
 */
public class Info extends JFrame{

    private JPanel InfoPanel;
    private JTable table;
    private JScrollPane jScrollPane;

    private Object[] th = new Object[5];
    private Object[][] td;

    public Info() {
        this.add(InfoPanel);
        this.setVisible(true);
        this.setSize(550,500);
    }

    public Info(Collection<Account> collection){
        this();
        th[0] = "ID";
        th[1] = "name";
        th[2] = "PersonID";
        th[3] = "telephone";
        th[4] = "balance";
        td = new Object[collection.size()][th.length];
        int total = 0;
        for (Account account : collection){
            td[total][0] = account.getID();
            td[total][1] = account.getName();
            td[total][2] = account.getPersonID();
            td[total][3] = account.getTel();
            td[total][4] = account.getBalance();
            total ++;
        }
        table = new JTable(td, th);
        table.setBounds(0, 0, 1000, 500);
        table.setVisible(true);
        table.setSize(700,600);
        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 0, 1000, 500);
        jScrollPane.setSize(700,600);
        InfoPanel.add(jScrollPane);
        jScrollPane.setVisible(true);
        InfoPanel.setVisible(true);
    }
}
