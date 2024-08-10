/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model; // Defines the package where the class resides

public class MedicalRecord { // Declaration of MedicalRecord class
    
   private int id; // Declaration of private integer variable id
   private int patient; // Declaration of private integer variable patient
   private String diagnoses; // Declaration of private String variable diagnoses
   private String treatments; // Declaration of private String variable treatments
   private String otherData; // Declaration of private String variable otherData
   
   public MedicalRecord(){ // Default constructor
   
   }

    public MedicalRecord(int patient, int id,  String diagnoses, String treatment, String otherData) { // Parameterized constructor
        this.id = id; // Assigning the id parameter to the class variable
        this.patient = patient; // Assigning the patient parameter to the class variable
        this.diagnoses = diagnoses; // Assigning the diagnoses parameter to the class variable
        this.treatments = treatment; // Assigning the treatment parameter to the class variable
        this.otherData = otherData; // Assigning the otherData parameter to the class variable
    }

    // Getters and setters
    public int getId() { // Getter method for id
        return id; // Returning id
    }

    public void setId(int id) { // Setter method for id
        this.id = id; // Setting the id
    }
    
    public int getPatient() { // Getter method for patient
        return patient; // Returning patient
    }

    public void setPatient(int patient) { // Setter method for patient
        this.patient = patient; // Setting the patient
    }
    
    public int getPatientId() { // Additional getter method to return the patient ID
        return getPatient(); // Simply return the patient ID using the existing getPatient() method.
    }
    
    public String getDiagnoses() { // Getter method for diagnoses
        return diagnoses; // Returning diagnoses
    }

    public void setDiagnoses(String diagnoses) { // Setter method for diagnoses
        this.diagnoses = diagnoses; // Setting the diagnoses
    }
    
    public String getTreatments() { // Getter method for treatments
        return treatments; // Returning treatments
    }

    public void settreatments(String treatments) { // Setter method for treatments
        this.treatments = treatments; // Setting the treatments
    }
    
    public String getOtherData() { // Getter method for otherData
        return otherData; // Returning otherData
    }

    public void setOthetData(String otherData) { // Setter method for otherData
        this.otherData = otherData; // Setting the otherData
    }  
}
