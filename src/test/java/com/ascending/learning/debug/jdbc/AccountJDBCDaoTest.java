package com.ascending.learning.debug.jdbc;

import com.ascending.learning.debug.model.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AccountJDBCDaoTest {
    private AccountJDBCDao accountJDBCDao;

    //Set up
    @Before
    public void init() {
        accountJDBCDao = new AccountJDBCDao();
    }

    //Test get method
    @Test
    public void getAccountsTest(){
        List<Account> accounts = accountJDBCDao.getAccounts();
        int expectedNumOfAcct = 5;

        Assert.assertEquals(expectedNumOfAcct, accounts.size());
    }

    //Test insert method
    @Test
    public void insertAccountsTest(){

    }

    //Test update method
    @Test
    public void updateAccountsTest(){

    }

    //Test delete method
    @Test
    public void deleteAccountsTest(){

    }

}
