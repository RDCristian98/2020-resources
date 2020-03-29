package com.company;

/**
 * Created by timotei on 4/11/17.
 */
public interface IAccountProvider {
    Account getAccount(String username, String password);
}
