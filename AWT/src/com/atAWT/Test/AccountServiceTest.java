package com.atAWT.Test;

import com.atAWT.service.AccountService;
import org.junit.Test;

/**
 * @author: Ding
 * @date: 2022/6/24
 * @description:
 * @modify:
 */

public class AccountServiceTest {
    private static AccountService accountService = new AccountService();

    public static void main(String[] args) {
        System.out.println(accountService.selectById(10012));
    }


}
