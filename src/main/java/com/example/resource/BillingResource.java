package com.example.resource;

// Import statements for required classes
import com.example.dao.BillingDAO;
import com.example.model.Billing;
import com.example.exception.UserNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Annotation to specify the base path for this resource
@Path("/billings")
public class BillingResource {

    // Create a logger instance for this class
    private static final Logger LOGGER = Logger.getLogger(BillingResource.class.getName());
    // Create an instance of BillingDAO
    private BillingDAO billingDAO = new BillingDAO();

    // GET method to retrieve a Billing by ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_Billing_ById(@PathParam("id") int id) {
        try {
            Billing billing = billingDAO.getBilling(id);
            if (billing != null) {
                LOGGER.log(Level.INFO, "Retrieved billing successfully");
                return Response.ok().entity(billing).build(); // Return the Billing object if found
            } else {
                throw new UserNotFoundException("Billing not found."); // Throw exception if not found
            }
        } catch (UserNotFoundException ex) {
            LOGGER.log(Level.WARNING, "Billing not found");
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build(); // Return 404 if not found
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Failed to fetch billings ", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to fetch billings").build(); // Return 500 if an exception occurs
        }
    }

    // GET method to retrieve all Billings
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_All_Billings() {
        try {
            List<Billing> billings = billingDAO.getAllBillings();
            LOGGER.log(Level.INFO, "Retrieved all billings");
            return Response.ok().entity(billings).build(); // Return the list of Billings
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Failed to get billings", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to fetch billings").build(); // Return 500 if an exception occurs
        }
    }

    // POST method to add a new Billing
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add_Billing(Billing billing) {
        try {
            billingDAO.addBilling(billing);
            LOGGER.log(Level.INFO, "Added billing successfully");
            return Response.status(Response.Status.CREATED).entity("Billing added successfully.").build(); // Return 201 if the Billing is added
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Failed to add billing", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to add billing.").build(); // Return 500 if an exception occurs
        }
    }

    // PUT method to update an existing Billing
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update_Billing(@PathParam("id") int billingId, Billing updatedBilling) {
        try {
            Billing existingBilling = billingDAO.getBilling(billingId);
            if (existingBilling != null) {
                updatedBilling.setInvoice_No(billingId);
                billingDAO.updateBilling(updatedBilling);
                LOGGER.log(Level.INFO, "Updated billing");
                return Response.ok().entity("Billing Updated").build(); // Return 200 if the Billing is updated successfully
            } else {
                throw new UserNotFoundException("Billing not found."); // Throw exception if not found
            }
        } catch (UserNotFoundException ex) {
            LOGGER.log(Level.WARNING, "Billing not found");
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build(); // Return 404 if not found
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Failed to update billings ", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to update billing").build(); // Return 500 if an exception occurs
        }
    }

    // DELETE method to delete a Billing by ID
    @DELETE
    @Path("/{id}")
    public Response delete_Billing(@PathParam("id") int id) {
        try {
            billingDAO.deleteBills(id);
            LOGGER.log(Level.INFO, "Deleted billing successfully");
            return Response.ok().entity("Billing deleted.").build(); // Return 200 if the Billing is deleted successfully
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Failed to delete billing", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to delete billings" + ex.getMessage()).build(); // Return 500 if an exception occurs
        }
    }
}