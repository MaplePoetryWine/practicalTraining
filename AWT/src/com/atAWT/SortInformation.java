package com.atAWT;

import com.atAWT.model.Account;

import javax.swing.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author wspstart
 * @create 2022-06-26 1:23
 */
public class SortInformation extends JFrame {
    private JPanel InfoPanel2;
    private JTable table;
    private JScrollPane jScrollPane;

    private Object[] th = new Object[6];
    private Object[][] td;

    public SortInformation() {
        this.add(InfoPanel2);
        this.setVisible(true);
        this.setSize(550, 500);
    }

    public SortInformation(LinkedHashMap<Integer, Account> allAccountOrderByBalance) {
        this();
        th[0] = "ID";
        th[1] = "name";
        th[2] = "PersonID";
        th[3] = "telephone";
        th[4] = "balance";
        th[5] = "账户类型";
        td = new Object[allAccountOrderByBalance.size()][th.length];
        Set<Integer> integers = allAccountOrderByBalance.keySet();
        int total = 0;
        for (Integer integer : integers) {
            Account account = allAccountOrderByBalance.get(integer);
            td[total][0] = account.getID();
            td[total][1] = account.getName();
            td[total][2] = account.getPersonID();
            td[total][3] = account.getTel();
            td[total][4] = account.getBalance();
            if (account.getClass() == Account.class) {
                td[total][5] = "储蓄账户";
            } else {
                td[total][5] = "贷款账户";
            }
            total ++;
        }
        table = new JTable(td, th);
        table.setBounds(0, 0, 1000, 500);
        table.setVisible(true);
        table.setSize(700, 600);
        jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 0, 1000, 500);
        jScrollPane.setSize(700, 600);
        InfoPanel2.add(jScrollPane);
        jScrollPane.setVisible(true);
        InfoPanel2.setVisible(true);
    }

}