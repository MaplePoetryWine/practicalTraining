package com.atAWT.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Dingstart
 * @create 2022-06-24 17:15
 * @modify Ding
 */
public class UserID {

    /**
     * 用户数量
     */
    private static int userTotal;

    private static final Properties properties;

    static {
        properties = new Properties();

        try (InputStream inputStream = UserID.class.getClassLoader().getResourceAsStream("com\\atAWT\\userTotal.properties")) {
            properties.load(inputStream);
            userTotal = Integer.parseInt(properties.getProperty("userTotal"));
        } catch (IOException e) {
            throw new RuntimeException("userTotal.properties 资源加载失败");
        }
    }

    public static int getID() {
        userTotal = Integer.parseInt(properties.getProperty("userTotal"));
        int id = userTotal + 1;
        try {
            properties.setProperty("userTotal", String.valueOf(id));

            properties.store(new FileOutputStream(new File("AWT\\src\\com\\atAWT\\userTotal.properties")), "newUserID");
        } catch (FileNotFoundException e) {
//            throw new RuntimeException("找不到 userTotal.properties");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException("更新 userID 失败");
        }
        return id;
    }
}
