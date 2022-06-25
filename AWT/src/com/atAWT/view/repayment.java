package com.atAWT.view;

import com.atAWT.model.LoanAccount;
import com.atAWT.service.LoanAccountService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-25 23:02
 */
public class repayment extends JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton okbutton;
    private JLabel error;
    private JPanel rePaymentPanel;
    private LoanAccountService loanAccountService = new LoanAccountService();
    public repayment(LoanAccount loanAccount) {
        this.add(rePaymentPanel);
        this.setVisible(true);
        this.setSize(600,500);
        okbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean repayment = loanAccountService.repayment(loanAccount.getID(), Double.parseDouble(textField1.getText())
                        , passwordField1.getText());
                if (repayment)
                    error.setText("还款成功！");
                else
                    error.setText("还款失败！");
            }
        });
    }
}
