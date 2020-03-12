package com.ascending.learning.debug.model;

public class Account {

    public Account() {}

    public Account(String type, float balance, long employeeId){
        this.type = type;
        this.balance = balance;
        this.employeeId = employeeId;
    }

    private long id;

    private String type;

    private float balance;

    private long employeeId;
}
