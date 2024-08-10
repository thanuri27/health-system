/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// This is a standard Java package declaration
package com.example.dao;

// Import statements for the required classes
import com.example.model.Billing;
import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eranda
 */

// This class defines a Data Access Object (DAO) for managing Billing objects
public class BillingDAO {

    // Declare a static list to hold all Billing objects
    private static final List<Billing> Billings = new ArrayList<>();

    // Static initializer block to add some sample Billing objects
    static {
        List<Patient> allPatients = PatientDAO.getAllPatients(); // Get all Patients from PatientDAO
        Billings.add(new Billing(1, allPatients.get(1), 500, 400, 100));
        Billings.add(new Billing(2, allPatients.get(0), 1000, 500, 500));
    }

    // Method to retrieve all Billings
    public List<Billing> getAllBillings() {
        return Billings;
    }

    // Method to retrieve a Billing by Invoice Number
    public Billing getBilling(int Id) {
        for (Billing billing : Billings) {
            if (billing.getInvoice_No() == Id) {
                return billing;
            }
        }
        return null; // If no Billing found, return null
    }

    // Create method to add a new Billing
    public void addBilling(Billing billing) {
        int newUserId = getNextBillId(); // Get the next available Invoice Number
        billing.setInvoice_No(newUserId); // Set the Invoice Number for the new Billing
        Billings.add(billing);
    }

    // Update method to update an existing Billing
    public void updateBilling(Billing updatedBilling) {
        for (int i = 0; i < Billings.size(); i++) {
            Billing billing = Billings.get(i);
            if (billing.getInvoice_No() == updatedBilling.getInvoice_No()) {
                Billings.set(i, updatedBilling); // Update the Billing in the list
                System.out.println("Billing updated: " + updatedBilling);
                return;
            }
        }
    }

    // Delete method to remove a Billing by Invoice Number
    public void deleteBills(int No) {
        Billings.removeIf(Billing -> Billing.getInvoice_No() == No); // Remove the Billing from the list
    }

    // Helper method to get the next available Invoice Number for a new Billing
    public int getNextBillId() {
        int maxUserId = Integer.MIN_VALUE;
        for (Billing Bill : Billings) {
            int userId = Bill.getInvoice_No();
            if (userId > maxUserId) {
                maxUserId = userId;
            }
        }
        return maxUserId + 1; // Return the next available Invoice Number
    }
}