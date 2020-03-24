package com.ascending.learning.debug.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    public Account() {}
    public Account(String type, float balance, long employeeId){
        this.type = type;
        this.balance = balance;
        this.employeeId = employeeId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "balance")
    private float balance;

    @Column(name = "employee_Id")
    private long employeeId;

    public long getID() { return id; }

    public void setID(long id) { this.id = id; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public float getBalance() { return balance; }

    public void setBalance(float balance) { this.balance = balance; }

    public long getEmployeeId() { return employeeId; }

    public void setEmployeeId(long employeeId) { this.employeeId = employeeId; }

}
