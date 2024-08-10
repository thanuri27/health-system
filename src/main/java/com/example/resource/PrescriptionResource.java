/* This class defines a JAX-RS resource for handling prescription-related operations. */

package com.example.resource; // Package declaration

import com.example.dao.PrescriptionDAO; // Importing necessary classes
import com.example.model.Prescription;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/prescriptions") // Resource path
public class PrescriptionResource {

    private static final Logger loggers = Logger.getLogger(PrescriptionResource.class.getName()); // Logger initialization
    private PrescriptionDAO prescription_DAO = new PrescriptionDAO(); // DAO instance creation

    @GET
    @Path("/{patientId}") // Path for retrieving prescription by patient ID
    @Produces(MediaType.APPLICATION_JSON) // Response type
    public Response get_Prescription(@PathParam("patientId") int id) {
        try {
            Prescription prescription = prescription_DAO.getPrescription(id); // Retrieve prescription
            if (prescription != null) {
                loggers.log(Level.INFO, "Data Loaded"); // Log success
                return Response.ok().entity(prescription).build(); // Response with prescription
            } else {
                loggers.log(Level.INFO, "No prescriptions"); // Log no prescription found
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No prescription found").build(); // Response for no prescription
            }
        } catch (Exception ex) {
            loggers.log(Level.SEVERE, "Not found Please Try again", ex); // Log error
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed").build(); // Error response
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) // Response type
    public List<Prescription> getAllPrescriptions() { // Retrieve all prescriptions
        return prescription_DAO.getAllPrescriptions(); // Return all prescriptions
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON) // Request type
    public Response add_Prescription(Prescription prescription) { // Add new prescription
        try {
            prescription_DAO.add_Prescription(prescription); // Add prescription
            loggers.log(Level.INFO, "prescription Added"); // Log success
            return Response.status(Response.Status.CREATED).build(); // Response for successful addition
        } catch (Exception ex) {
            loggers.log(Level.SEVERE, "Something went wrong", ex); // Log error
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed").build(); // Error response
        }
    }

    @DELETE
    @Path("/{id}") // Path for prescription deletion
    public Response delete_Student(@PathParam("id") int id) { // Delete prescription
        try {
            prescription_DAO.delete_Prescription(id); // Delete prescription by ID
            loggers.log(Level.INFO, "Deleted successfully"); // Log success
            return Response.ok().build(); // Success response
        } catch (Exception ex) {
            loggers.log(Level.SEVERE, "Not Found", ex); // Log error
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed! lease Try again ").build(); // Error response
        }
    }
}
