package com.ascending.learning.debug.model;

//Create a model to match the database table - department
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

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }
}
