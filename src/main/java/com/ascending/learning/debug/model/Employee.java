package com.ascending.learning.debug.model;


import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    public Employee() {}
    public Employee(String name, String firstName, String lastName, String email, String address, int age, float salary, Department department){
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private float salary;

//    @Column(name = "department_Id")
//    private long departmentId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
    //fetch_type=lazy select * from department
    //HQL select e from Employee as e join fetch e.department where e.department.id = :id;
    //native sql fetch_type=eager select * from employee as e left join department as d on e.department_id = d.id

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

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }

}
