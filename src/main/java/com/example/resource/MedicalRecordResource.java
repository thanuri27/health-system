// Package declaration
package com.example.resource;

// Import statements
import com.example.dao.MedicalRecordDAO; // Importing MedicalRecordDAO class
import com.example.model.MedicalRecord; // Importing MedicalRecord class
import java.util.List; // Importing List interface
import javax.ws.rs.*; // Importing JAX-RS annotations
import javax.ws.rs.core.MediaType; // Importing MediaType class from javax.ws.rs.core package
import javax.ws.rs.core.Response; // Importing Response class from javax.ws.rs.core package
import org.slf4j.Logger; // Importing Logger interface from org.slf4j package
import org.slf4j.LoggerFactory; // Importing LoggerFactory class from org.slf4j package

// Resource path annotation
@Path("/medical-records")
// Declaration of MedicalRecordResource class
public class MedicalRecordResource {

    // Logger initialization
    private static final Logger loggers = LoggerFactory.getLogger(MedicalRecordResource.class);
    // Instantiating MedicalRecordDAO object
    private final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    // Method to get all medical records
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> get_All_Medical_Records() {
        return medicalRecordDAO.getAllMedicalRecords();
    }

    // Method to get medical records by patient ID
    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> get_Medical_Record(@PathParam("patientId") int id) {
        return medicalRecordDAO.getMedicalRecords(id);
    }

    // Method to add a new medical record
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_Medical_Record(MedicalRecord medicalRecord) {
        try {
            medicalRecordDAO.Add_MedicalRecord(medicalRecord);
            loggers.info("Successfully added the Medical Record: " + medicalRecord.getId());
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            throw new WebApplicationException("Medical Record added Failed", ex);
        }
    }

    // Method to delete a medical record by ID
    @DELETE
    @Path("/{ID}")
    public void delete_Student_ById(@PathParam("ID") int id) {
        try {
            medicalRecordDAO.Delete_MedicalRecord(id);
        } catch (Exception ex) {
            loggers.error("Error Occurred", id, ex.getMessage());
            throw new WebApplicationException("Failed to Delete", ex);
        }
    }
}
