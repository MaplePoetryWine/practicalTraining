package com.atAWT.view;

import com.atAWT.model.LoanAccount;
import com.atAWT.service.LoanAccountService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-25 22:51
 */
public class loan extends JFrame{
    private JTextField moneytextField1;
    private JPasswordField passwordField1;
    private JButton OKButton;
    private JLabel error;
    private JPanel loanPanel;
    private LoanAccountService loanAccountService = new LoanAccountService();
    public loan(LoanAccount loanAccount) {
        this.add(loanPanel);
        this.setVisible(true);
        this.setSize(2560,1600);//
        OKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean loan = loanAccountService.loan(loanAccount.getID(), Double.parseDouble(moneytextField1.getText())
                        , passwordField1.getText());
                if (loan)
                    error.setText("贷款成功！您已成功贷款" + moneytextField1.getText() + "元。");
                else
                    error.setText("贷款失败！！！");
            }
        });
    }
}
