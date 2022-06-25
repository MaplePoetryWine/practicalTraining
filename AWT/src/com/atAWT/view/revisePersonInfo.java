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
    private JLabel welom;
    private JPanel revisePersonInfoPanel;
    private JButton 确定Button;
    private JLabel error;

    public revisePersonInfo(Account account){
        pswtextField.setText(account.getPassword());
        nametextField.setText(account.getName());
        teltextField.setText(account.getTel());
        this.add(revisePersonInfoPanel);
        this.setSize(400,600);
        this.setVisible(true);

        确定Button.addMouseListener(new MouseAdapter() {
            //test
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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
                    error.setText("修改成功！！！");
                    toClose();
            }
        });
    }

    private void toClose() {
        this.setVisible(false);
    }

}
