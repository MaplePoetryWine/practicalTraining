package com.atAWT.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author wspstart
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
        InputStream inputStream = UserID.class.getClassLoader().getResourceAsStream("com/atAWT/userTotal.properties");
        try {
            properties.load(inputStream);
            userTotal = Integer.parseInt(properties.getProperty("userTotal"));
        } catch (IOException e) {
            throw new RuntimeException("userTotal.properties 资源加载失败");
        }
    }

    public static int getID() {
        int id = userTotal + 1;
        properties.setProperty("userTotal", String.valueOf(id));
        return id;
    }
}
