package com.ascending.learning.debug.model;

public class Department {

    public Department() {}

    public Department(String name, String description, String location){
        this.name = name;
        this.description = description;
        this.location = location;
    }

    private long id;

    private String name;

    private String description;

    private String location;

    public long getID() { return id; }

    public void setId(long id) {this.id = id; }

    public void setName(String name) {this.name = name; }

    public void setDescription(String description) {this.description = description; }

    public void setLocation(String location) {this.location = location; }

    public String getName() { return name; }
}
