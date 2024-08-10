package com.example.model; // Defines the package where the class resides

public class Patient extends Person { // Declaration of Patient class, extending Person class

    private String medical_history; // Declaration of private String variable medical_history
    private String current_health_status; // Declaration of private String variable current_health_status
    
    public Patient(){ // Default constructor
    
    }

    public Patient(int id, String name, String gender, String address, String medical_history, String current_health_status, int age) { // Parameterized constructor
        super(id, name, gender, address, age); // Calling the constructor of the superclass (Person)
        this.medical_history = medical_history; // Assigning the medical_history parameter to the class variable
        this.current_health_status = current_health_status; // Assigning the current_health_status parameter to the class variable
    }

    // Getters and setters
    public String getMedical_history() { // Getter method for medical_history
        return medical_history; // Returning medical_history
    }

    public void setMedical_history(String medical_history) { // Setter method for medical_history
        this.medical_history = medical_history; // Setting the medical_history
    }

    public String getCurrent_health_status() { // Getter method for current_health_status
        return current_health_status; // Returning current_health_status
    }

    public void setCurrent_health_status(String current_health_status) { // Setter method for current_health_status
        this.current_health_status = current_health_status; // Setting the current_health_status
    }
}
