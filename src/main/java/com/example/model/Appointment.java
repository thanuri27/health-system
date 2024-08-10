package com.example.model; // Defines the package where the class resides

import java.time.LocalDate; // Importing LocalDate class from java.time package
import java.time.LocalDateTime; // Importing LocalDateTime class from java.time package
import java.time.LocalTime; // Importing LocalTime class from java.time package

public class Appointment { // Declaration of Appointment class

    private int app_num;  // Declaration of private integer variable app_num
    private Patient patient; // Declaration of private Patient variable patient
    private Doctor doctor; // Declaration of private Doctor variable doctor
    private String date; // Declaration of private String variable date
    private String time; // Declaration of private String variable time

    public Appointment(){ // Default constructor
    }

    public Appointment(int app_num, String date, String time, Patient patient, Doctor doctor) { // Parameterized constructor
        this.app_num = app_num; // Assigning the app_num parameter to the class variable
        this.patient = patient; // Assigning the patient parameter to the class variable
        this.doctor = doctor; // Assigning the doctor parameter to the class variable
        this.date = date; // Assigning the date parameter to the class variable
        this.time = time; // Assigning the time parameter to the class variable
    }

    // Getters and setters
    public int getApp_num() { // Getter method for app_num
        return app_num; // Returning app_num
    }

    public void setApp_num(int app_num) { // Setter method for app_num
        this.app_num = app_num; // Setting the app_num
    }

    public Patient getPatient() { // Getter method for patient
        return patient; // Returning patient
    }

    public void setPatient(Patient patient) { // Setter method for patient
        this.patient = patient; // Setting the patient
    }

    public Doctor getDoctor() { // Getter method for doctor
        return doctor; // Returning doctor
    }

    public void setDoctor(Doctor doctor) { // Setter method for doctor
        this.doctor = doctor; // Setting the doctor
    }

    public String getDate() { // Getter method for date
        return date; // Returning date
    }

    public void setDate(String date) { // Setter method for date
        this.date = date; // Setting the date
    }
    
    public String getTime() { // Getter method for time
        return time; // Returning time
    }

    public void setTime(String time) { // Setter method for time
        this.time = time; // Setting the time
    }
}
