/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// This is a standard Java package declaration
package com.example.resource;

// Import statements for required classes
import com.example.dao.DoctorDAO;
import com.example.model.Doctor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Annotation to specify the base path for this resource
@Path("/doctors")

// This class defines a RESTful resource for managing Doctor objects
public class DoctorResource {

    // Create a logger instance for this class
    private static final Logger LOGGER = Logger.getLogger(DoctorResource.class.getName());

    // Create an instance of DoctorDAO
    private DoctorDAO doctorDAO = new DoctorDAO();

    // GET method to retrieve a Doctor by ID
    @GET
    @Path("/{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_Doctor_ById(@PathParam("Id") int id) {
        try {
            Doctor doctor = doctorDAO.getDoctorById(id);
            if (doctor != null) {
                return Response.ok(doctor).build(); // Return the Doctor object if found
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build(); // Return 404 if not found
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error getting doctor by ID", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error getting doctor").build(); // Return 500 if an exception occurs
        }
    }

    // GET method to retrieve all Doctors
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_All_Doctors() {
        try {
            List<Doctor> doctors = DoctorDAO.getAllDoctors();
            LOGGER.log(Level.INFO, "Retrieved all Doctors");
            return Response.ok().entity(doctors).build(); // Return the list of Doctors
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Failed to get doctors", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to get doctors.").build(); // Return 500 if an exception occurs
        }
    }

    // POST method to add a new Doctor
    @POST
    public Response add_Doctor(Doctor doctor) {
        try {
            doctorDAO.add_Doctor(doctor);
            return Response.status(Response.Status.CREATED).entity("Doctor added successfully.").build(); // Return 201 if the Doctor is added
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error adding doctor", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding doctor").build(); // Return 500 if an exception occurs
        }
    }

    // PUT method to update an existing Doctor
    @PUT
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update_Doctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor) {
        try {
            Doctor existingDoctor = doctorDAO.getDoctorById(doctorId);
            if (existingDoctor != null) {
                updatedDoctor.setID(doctorId);
                doctorDAO.update_Doctor(updatedDoctor);
                return Response.noContent().build(); // Return 204 if the Doctor is updated successfully
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build(); // Return 404 if the Doctor is not found
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error updating doctor", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating doctor").build(); // Return 500 if an exception occurs
        }
    }

    // DELETE method to delete a Doctor by ID
    @DELETE
    @Path("/{Id}")
    public Response delete_Doctor(@PathParam("Id") int id) {
        try {
            doctorDAO.delete_Doctor(id);
            LOGGER.log(Level.INFO, "Deleted doctor with ID {0} successfully", id);
            return Response.ok().entity("Doctor with ID " + id + " successfully deleted.").build(); // Return 200 if the Doctor is deleted successfully
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error deleting doctor", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting doctor").build(); // Return 500 if an exception occurs
        }
    }
}