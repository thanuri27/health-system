package com.example.model; // Package declaration

public class Billing { // Billing class declaration

    private int invoice_No; // Invoice number
    private Patient patient; // Associated patient
    private double payment_Amount; // Amount paid
    private double total_Amount; // Total amount
    private double balance; // Remaining balance

    public Billing(){ } // Default constructor

    // Parameterized constructor
    public Billing(int invoice_No, Patient patient, double payment_Amount, double total_Amount, double balance ){
        this.invoice_No = invoice_No; // Set invoice number
        this.patient = patient; // Set associated patient
        this.total_Amount = total_Amount; // Set total amount
        this.payment_Amount = payment_Amount; // Set payment amount
        this.balance = payment_Amount - total_Amount; // Calculate and set balance
    }

    public Patient getPatient() { 
        return patient; } // Getter for patient
    public void setPatient(Patient patient) {
        this.patient = patient; } // Setter for patient

    public int getInvoice_No() { 
        return invoice_No; } // Getter for invoice number
    public void setInvoice_No(int invoice_No) { 
        this.invoice_No = invoice_No; } // Setter for invoice number

    public double getPayment_Amount() {
        return payment_Amount; } // Getter for payment amount
    public void setayment_Amount(double payment_Amount) { 
        this.payment_Amount = payment_Amount; } // Setter for payment amount

    public double getTotal_Amount() {
        return total_Amount; } // Getter for total amount
    public void setTotal_Amount(double total_Amount) {
        this.total_Amount = total_Amount; } // Setter for total amount

    public double getBalance() {
        return balance; } // Getter for balance
    public void setBalance(double balance) {
        this.balance = balance; } // Setter for balance
}
