package com.atAWT.service;

import com.atAWT.model.Account;
import com.atAWT.model.U;

/**
 * @author: Ding
 * @date: 2022/6/24
 * @description:
 * @modify:
 */

public class AccountService {

    /**
     * 处理登录请求，返回登录用户的对象，若为 null 表示该用户不存在
     * @param accountId
     * @param password
     * @return
     */
    public Account login(String accountId, String password) {
        Account account = U.accountMap.get(Integer.parseInt(accountId));
        if (account != null
                && password != null
                && password.equals(account.getPassword())) {
            return account;
        } else {
            return null;
        }
    }

    /**
     * 处理注册请求
     * @param account 返回注册用户的对象，若为 null 则注册失败
     * @return
     */
    public Account register(Account account) {
        if (U.addCount(account)) {
            return account;
        } else {
            return null;
        }
    }
}
