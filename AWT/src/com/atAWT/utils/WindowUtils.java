package com.atAWT.utils;

import javax.swing.*;

/**
 * @author wspstart
 * @create 2022-06-24 14:30
 * @description 创建一个新的窗口或对话框
 */

public class WindowUtils {

    public static void openJFrame(JFrame jFrame) {
        jFrame.setBounds(0, 0, 1920, 1040);
        jFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void createOneDialog(JDialog dialog) {
        dialog.pack();
        dialog.setBounds(400, 300, 500, 400);
        dialog.setVisible(true);
    }
}
