/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model; // Defines the package where the class resides

public class Prescription { // Declaration of Prescription class
    
    private Patient patient; // Declaration of private Patient variable patient
    private Doctor doctor; // Declaration of private Doctor variable doctor
    private String medicine; // Declaration of private String variable medicine
    private int dosagePer_meal; // Declaration of private integer variable dosagePer_meal
    private String instructions; // Declaration of private String variable instructions
    private int durationIn_days; // Declaration of private integer variable durationIn_days
    
    public Prescription(){ // Default constructor
    
    }

    public Prescription(Patient patient, Doctor doctor, String medicine, int dosagePer_meal, String instructions, int durationIn_days) { // Parameterized constructor
        this.patient = patient; // Assigning the patient parameter to the class variable
        this.doctor = doctor; // Assigning the doctor parameter to the class variable
        this.medicine = medicine; // Assigning the medicine parameter to the class variable
        this.dosagePer_meal = dosagePer_meal; // Assigning the dosagePer_meal parameter to the class variable
        this.instructions = instructions; // Assigning the instructions parameter to the class variable
        this.durationIn_days = durationIn_days; // Assigning the durationIn_days parameter to the class variable
    }

    // Getters and setters
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

    public String getMedicine() { // Getter method for medicine
        return medicine; // Returning medicine
    }

    public void setMedicine(String medicine) { // Setter method for medicine
        this.medicine = medicine; // Setting the medicine
    }

    public int getDosagePer_meal() { // Getter method for dosagePer_meal
        return dosagePer_meal; // Returning dosagePer_meal
    }

    public void setDosagePer_meal(int dosagePer_meal) { // Setter method for dosagePer_meal
        this.dosagePer_meal = dosagePer_meal; // Setting the dosagePer_meal
    }

    public String getInstructions() { // Getter method for instructions
        return instructions; // Returning instructions
    }

    public void setInstructions(String instructions) { // Setter method for instructions
        this.instructions = instructions; // Setting the instructions
    }

    public int getDurationIn_days() { // Getter method for durationIn_days
        return durationIn_days; // Returning durationIn_days
    }

    public void setDurationIn_days(int durationIn_days) { // Setter method for durationIn_days
        this.durationIn_days = durationIn_days; // Setting the durationIn_days
    }
}
