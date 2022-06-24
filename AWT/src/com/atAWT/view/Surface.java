package com.atAWT.view;

import com.atAWT.model.Account;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;

/**
 * @author wspstart
 * @create 2022-06-24 15:53
 */
public class Surface extends JFrame{
    private JButton ViewLoanBalanceButton;
    private JButton loanButton;
    private JButton withdrawalButton;
    private JButton TransferButton;
    private JButton viewPersonalInformationButton;
    private JButton modifyPersonalInformationButton;
    private JButton checkBalanceButton;
    private JPanel surface;


    public Surface() {
        this.add(surface);
        checkBalanceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        this.setSize(400,600);
        this.setLocation(500,600);
        this.setVisible(true);
        viewPersonalInformationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }
}
