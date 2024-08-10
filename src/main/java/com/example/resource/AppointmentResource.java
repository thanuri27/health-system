package com.example.resource;

// Import statements for required classes
import com.example.dao.AppointmentDAO;
import com.example.model.Appointment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Annotation to specify the base path for this resource
@Path("/appointments")

public class AppointmentResource {

    // Create a logger instance for this class
    private static final Logger logger = Logger.getLogger(AppointmentResource.class.getName());

    // Create an instance of AppointmentDAO
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    // GET method to retrieve an Appointment by ID
    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_Appointment_ById(@PathParam("appointmentId") int appointmentId) {
        try {
            Appointment appointment = appointmentDAO.getAppointmentById(appointmentId);
            if (appointment != null) {
                logger.log(Level.INFO, "Retrieved appointment successfully");
                return Response.ok().entity(appointment).build(); // Return the Appointment object if found
            } else {
                logger.log(Level.INFO, "Appointment not found");
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Appointment not found").build(); // Return 404 if not found
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to get appointment", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to fetch appointment").build(); // Return 500 if an exception occurs
        }
    }

    // GET method to retrieve all Appointments
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_All_Appointments() {
        try {
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
            logger.log(Level.INFO, "Retrieved data");
            return Response.ok().entity(appointments).build(); // Return the list of Appointments
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to get appointments", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed.").build(); // Return 500 if an exception occurs
        }
    }

    // POST method to add a new Appointment
    @POST
    public Response Add_Appointment(Appointment appointment) {
        try {
            appointmentDAO.addAppointment(appointment);
            logger.log(Level.INFO, "Added new appointment successfully");
            return Response.status(Response.Status.CREATED).build(); // Return 201 if the Appointment is added
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to add appointment", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to add appointment. Please try again later.").build(); // Return 500 if an exception occurs
        }
    }

    // PUT method to update an existing Appointment
    @PUT
    @Path("/{appointmentId}")
    public Response update_Appointment(@PathParam("appointmentId") int appointmentId, Appointment updatedAppointment) {
        try {
            appointmentDAO.updateAppointment(appointmentId, updatedAppointment);
            logger.log(Level.INFO, "Updated appointment successfully");
            return Response.ok().build(); // Return 200 if the Appointment is updated successfully
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to update", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to update").build(); // Return 500 if an exception occurs
        }
    }

    // DELETE method to delete an Appointment by ID
    @DELETE
    @Path("/{appointmentId}")
    public Response delete_Appointment(@PathParam("appointmentId") int appointmentId) {
        try {
            appointmentDAO.deleteAppointment(appointmentId);
            logger.log(Level.INFO, "Deleted appointment successfully");
            return Response.ok().entity("Appointment successfully deleted.").build(); // Return 200 if the Appointment is deleted successfully
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to delete appointment ", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to delete appointment").build(); // Return 500 if an exception occurs
        }
    }
}