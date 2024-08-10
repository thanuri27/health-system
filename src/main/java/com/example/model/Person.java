/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model; // Defines the package where the class resides

public class Person { // Declaration of Person class
    
    private int id; // Declaration of private integer variable id
    private String name; // Declaration of private String variable name
    private String gender; // Declaration of private String variable gender
    private String address; // Declaration of private String variable address
    private int age; // Declaration of private integer variable age
    
    public Person(){ // Default constructor
    
    }

    public Person(int id, String name, String gender, String address, int age) { // Parameterized constructor
        this.id = id; // Assigning the id parameter to the class variable
        this.name = name; // Assigning the name parameter to the class variable
        this.gender = gender; // Assigning the gender parameter to the class variable
        this.address = address; // Assigning the address parameter to the class variable
        this.age = age; // Assigning the age parameter to the class variable
    }
    
    // Getters and setters
    public int getID() { // Getter method for id
        return id; // Returning id
    }

    public void setID(int id) { // Setter method for id
        this.id = id; // Setting the id
    }

    public String getName() { // Getter method for name
        return name; // Returning name
    }

    public void setName(String name) { // Setter method for name
        this.name = name; // Setting the name
    }

    public String getGender() { // Getter method for gender
        return gender; // Returning gender
    }

    public void setGender(String gender) { // Setter method for gender
        this.gender = gender; // Setting the gender
    }

    public String getAddress() { // Getter method for address
        return address; // Returning address
    }

    public void setAddress(String address) { // Setter method for address
        this.address = address; // Setting the address
    }
    
    public int getAge() { // Getter method for age
        return age; // Returning age
    }

    public void setAge(int age) { // Setter method for age
        this.age = age; // Setting the age
    }
}
