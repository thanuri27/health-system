package com.example.dao;

// Import statements for the required classes
import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Patient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;

// This class defines a Data Access Object (DAO) for managing Appointment objects
public class AppointmentDAO {

    // Declare a static list to hold all Appointment objects
    private static final List<Appointment> Appointments = new ArrayList<>();

    // Static initializer block to add some sample Appointment objects
    static {
        LocalDate date = LocalDate.now(); // Get the current date
        LocalTime time = LocalTime.now(); // Get the current time
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd"); // Define date format
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm"); // Define time format
        String formattedDate = date.format(dateFormatter); // Format the date
        String formattedTime = time.format(timeFormatter); // Format the time

        List<Patient> allPatients = PatientDAO.getAllPatients(); // Get all Patients from PatientDAO
        List<Doctor> allDoctors = DoctorDAO.getAllDoctors(); // Get all Doctors from DoctorDAO

        // Create appointments and add them to the list
        Appointments.add(new Appointment(1, formattedDate, formattedTime, allPatients.get(0), allDoctors.get(0)));
        Appointments.add(new Appointment(2, formattedDate, formattedTime, allPatients.get(1), allDoctors.get(1)));
    }

    // Method to retrieve all Appointments
    public List<Appointment> getAllAppointments() {
        return Appointments;
    }

    // Method to retrieve an Appointment by ID
    public Appointment getAppointmentById(int appointmentId) {
        for (Appointment appointment : Appointments) {
            if (appointment.getApp_num() == appointmentId) {
                return appointment;
            }
        }
        return null; // If no Appointment found, return null
    }

    // Create method to add a new Appointment
    public void addAppointment(Appointment appointment) {
        int newUserId = getNextAppointmentId(); // Get the next available Appointment ID
        appointment.setApp_num(newUserId); // Set the Appointment ID for the new Appointment
        Appointments.add(appointment);
    }

    // Update method to update an existing Appointment (not fully implemented)
    public void updateAppointment(int appointmentId, Appointment updatedAppointment) throws NotFoundException {
        Appointment appointment = getAppointmentById(appointmentId);
        appointment.setDate(updatedAppointment.getDate()); // Update the date
    }

    // Update method to update an existing Appointment
    public void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < Appointments.size(); i++) {
            Appointment appointment = Appointments.get(i);
            if (appointment.getApp_num() == updatedAppointment.getApp_num()) {
                Appointments.set(i, updatedAppointment); // Update the Appointment in the list
                System.out.println("Appointment Updated: " + updatedAppointment);
                return;
            }
        }
    }

    // Delete method to remove an Appointment by ID
    public void deleteAppointment(int appointmentId) throws NotFoundException {
        Appointments.removeIf(appoin -> appoin.getApp_num() == appointmentId); // Remove the Appointment from the list
    }

    // Helper method to get the next available ID for a new Appointment
    public int getNextAppointmentId() {
        int maxUserId = Integer.MIN_VALUE;
        for (Appointment apointment : Appointments) {
            int AppointmentId = apointment.getApp_num();
            if (AppointmentId > maxUserId) {
                maxUserId = AppointmentId;
            }
        }
        return maxUserId + 1; // Return the next available ID
    }
}