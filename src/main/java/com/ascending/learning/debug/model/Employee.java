package com.ascending.learning.debug.model;

public class Employee {
    public Employee() {}

    public Employee(String name, String firstName, String lastName, String email, String address, int age, float salary, long departmentId){
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    private long id;

    private String name;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private int age;

    private float salary;

    private long departmentId;

}
