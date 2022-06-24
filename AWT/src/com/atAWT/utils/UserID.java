package com.atAWT.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wspstart
 * @create 2022-06-24 17:15
 */
public class UserID {
    private static List<Integer> list = new ArrayList<>();
    private static int total = 0;

    static {
        for (int i = 10007; i <= 999999; i++)
            list.add(i);
    }

    public static int getID() {
        int ID = UserID.list.get(total++);
        if (total >= 98991) {
            System.out.println("error: total数过大，不能继续添加用户了！！！");
            System.exit(0);
        }
        return ID;
    }
}
