package com.atAWT.view;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author wspstart
 * @create 2022-06-25 22:10
 */
public class loanEligibility extends JFrame{
    private JButton detectButton;
    private JButton NOButton;
    private JPanel isloanPanel;
    private JLabel error;

    public loanEligibility() {
        this.add(isloanPanel);
        this.setVisible(true);
        this.setSize(2560,1600);
        detectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                error.setText("恭喜您！您具有开通贷款账户的资格。");
            }
        });
        NOButton.addMouseListener(new MouseAdapter() {
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
