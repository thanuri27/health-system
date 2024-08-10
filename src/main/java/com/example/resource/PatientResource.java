// Package declaration
package com.example.resource;

// Import statements
import com.example.dao.PatientDAO; // Importing PatientDAO class
import com.example.model.Patient; // Importing Patient class
import com.example.exception.UserNotFoundException; // Importing UserNotFoundException class
import java.util.List; // Importing List interface
import java.util.logging.Level; // Importing Level class from java.util.logging package
import java.util.logging.Logger; // Importing Logger class from java.util.logging package
import javax.ws.rs.*; // Importing JAX-RS annotations
import javax.ws.rs.core.MediaType; // Importing MediaType class from javax.ws.rs.core package
import javax.ws.rs.core.Response; // Importing Response class from javax.ws.rs.core package

// Resource path annotation
@Path("/patients")
// Declaration of PatientResource class
public class PatientResource {
    
    // Logger initialization
    private static final Logger loggers = Logger.getLogger(PatientResource.class.getName());
    // Instantiating PatientDAO object
    private PatientDAO patient_DAO = new PatientDAO();

    // Method to get all patients
    @GET
    // Specifies the MIME media types that a resource can produce and send back to the client
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_All_Patients() {
        try {
            // Retrieving all patients from the database
            List<Patient> patients = patient_DAO.getAllPatients();
            // Logging information message
            loggers.log(Level.INFO, "Retrieved All Patients");
            // Returning a successful response with the list of patients
            return Response.ok().entity(patients).build();
        } catch (Exception ex) {
            // Logging severe message for failure
            loggers.log(Level.SEVERE, "Failed to Get Patients", ex);
            // Returning an internal server error response with a message
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to Get Patients.").build();
        }
    }

    // Method to get a patient by ID
    @GET
    // Specifies a relative path for the resource URI
    @Path("/{id}")
    // Specifies the MIME media types that a resource can produce and send back to the client
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_PatientById(@PathParam("id") int id) {
        try {
            // Retrieving a patient by ID from the database
            Patient patient = patient_DAO.getPatientById(id);
            // Checking if the patient exists
            if (patient != null) {
                // Logging information message
                loggers.log(Level.INFO, "Retrieved Patients", id);
                // Returning a successful response with the patient
                return Response.ok().entity(patient).build();
            } else {
                // Throwing a UserNotFoundException if the patient does not exist
                throw new UserNotFoundException("NOT FOUND.");
            }
        } catch (UserNotFoundException ex) {
            // Logging warning message
            loggers.log(Level.WARNING, "Patient Not Found", id);
            // Returning a not found response with the exception message
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        } catch (Exception ex) {
            // Logging severe message for failure
            loggers.log(Level.SEVERE, "FAILED! ", ex);
            // Returning an internal server error response with a message
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("FAILED").build();
        }
    }

    // Method to add a new patient
    @POST
    // Specifies the MIME media types that a resource can consume
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_Patient(Patient patient) {
        try {
            // Adding the patient to the database
            patient_DAO.add_Patient(patient);
            // Logging information message
            loggers.log(Level.INFO, "Added Patient");
            // Returning a created response
            return Response.status(Response.Status.CREATED).entity("Patient added").build();
        } catch (Exception ex) {
            // Logging severe message for failure
            loggers.log(Level.SEVERE, "FAILED", ex);
            // Returning an internal server error response with a message
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to Add Patient.").build();
        }
    }

    // Method to update a patient
    @PUT
    // Specifies a relative path for the resource URI
    @Path("/{id}")
    // Specifies the MIME media types that a resource can consume
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update_Patient(@PathParam("id") int patientId, Patient updatePatient) {
        try {
            // Retrieving the existing patient by ID
            Patient existingPatient = patient_DAO.getPatientById(patientId);
            // Checking if the existing patient exists
            if (existingPatient != null) {
                // Setting the ID of the updated patient
                updatePatient.setID(patientId);
                // Updating the patient in the database
                patient_DAO.update_Patient(updatePatient);
                // Logging information message
                loggers.log(Level.INFO, "Patient Updated");
                // Returning a successful response
                return Response.ok().entity("Patient Updated").build();
            } else {
                // Throwing a UserNotFoundException if the existing patient does not exist
                throw new UserNotFoundException("Patient Not Found.");
            }
        } catch (UserNotFoundException ex) {
            // Logging warning message
            loggers.log(Level.WARNING, "Patient Not Found");
            // Returning a not found response with the exception message
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        } catch (Exception ex) {
            // Logging severe message for failure
            loggers.log(Level.SEVERE, "Failed ", ex);
            // Returning an internal server error response with a message
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to Update Patient").build();
        }
    }

    // Method to delete a patient
    @DELETE
    // Specifies a relative path for the resource URI
    @Path("/{id}")
    public Response delete_Patient(@PathParam("id") int id) {
        try {
            // Deleting the patient from the database
            patient_DAO.delete_Patient(id);
            // Logging information message
            loggers.log(Level.INFO, "Deleted Patient");
            // Returning a successful response
            return Response.ok().entity("Patient Deleted.").build();
        } catch (Exception ex) {
            // Logging severe message for failure
            loggers.log(Level.SEVERE, "Failed to Delete", ex);
            // Returning an internal server error response with a message
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to Delete " + ex.getMessage()).build();
        }
    }
}
