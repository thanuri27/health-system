package com.example.dao;

// Import statement for the required class
import com.example.model.Doctor;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

// DoctorDAO extends PersonDAO
public class DoctorDAO extends PersonDAO {

    // Declare a static list to hold all Doctor objects
    private static final List<Doctor> Doctors = new ArrayList<>();

    // Static initializer block to add some sample Doctor objects
    static {
        Doctors.add(new Doctor(5, "Doc01", "male", "lane01", "Spc001", 34));
        Doctors.add(new Doctor(6, "Doc02", "female", "lane02", "Spc001", 45));
    }

    // Method to get all Doctors
    public static List<Doctor> getAllDoctors() {
        return Doctors;
    }

    // Create method to add a new Doctor
    public void add_Doctor(Doctor doctor) {
        int newDoctorId = getNextDoctorId(); // Get the next available ID
        doctor.setID(newDoctorId); // Set the ID for the new Doctor
        addPerson(doctor); // Add the Doctor to the base PersonDAO
        Doctors.add(doctor); // Add the Doctor to the Doctors list
    }

    // Method to retrieve a Doctor by ID
    public Doctor getDoctorById(int id) throws NotFoundException {
        for (Doctor doctor : Doctors) {
            if (doctor.getID() == id) {
                return doctor;
            }
        }
        // If no Doctor found, throw a NotFoundException
        throw new NotFoundException("Doctor is not found: " + id);
    }

    // Update method to update an existing Doctor
    public void update_Doctor(Doctor updatedStudent) {
        for (int i = 0; i < Doctors.size(); i++) {
            Doctor doctor = Doctors.get(i);
            if (doctor.getID() == updatedStudent.getID()) {
                Doctors.set(i, updatedStudent); // Update the Doctor in the list
                System.out.println("Doctor updated: " + updatedStudent);
                return;
            }
        }
    }

    // Delete method to remove a Doctor by ID
    public void delete_Doctor(int id) throws NotFoundException {
        Doctors.removeIf(doctor1 -> doctor1.getID() == id); // Remove the Doctor from the list
    }

    // Helper method to get the next available ID for a new Doctor
    public int getNextDoctorId() {
        int maxDoctorId = Integer.MIN_VALUE;
        for (Doctor doctor : Doctors) {
            int userId = doctor.getID();
            if (userId > maxDoctorId) {
                maxDoctorId = userId;
            }
        }
        return maxDoctorId + 1; // Return the next available ID
    }
}