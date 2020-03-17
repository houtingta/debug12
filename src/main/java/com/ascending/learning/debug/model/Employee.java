package com.ascending.learning.debug.model;

import jdk.nashorn.internal.codegen.ClassEmitter;

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

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName;}

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public float getSalary() { return salary; }

    public void setSalary(float salary) { this.salary = salary; }

    public long getDepartmentId() { return departmentId; }

    public void setDepartmentId(long departmentId) { this.departmentId = departmentId; }
    
}
