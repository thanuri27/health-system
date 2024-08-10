package com.example.model; // Package declaration

public class Doctor extends Person { // Doctor class extending Person class

   private String specialization_in; // Doctor's specialization

   public Doctor() { } // Default constructor

   // Constructor with parameters
   public Doctor(int id, String name, String gender, String address, String specialization_in, int age) {
       super(id, name, gender, address, age); // Call to super constructor
       this.specialization_in = specialization_in; // Initializing specialization
   }

   // Getter for specialization
   public String getSpecialization_in() {
       return specialization_in; // Return specialization
   }

   // Setter for specialization
   public void setSpecialization_in(String specialization_in) {
       this.specialization_in = specialization_in; // Set specialization
   }
}
