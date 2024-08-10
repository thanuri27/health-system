package com.example.resource; // Package declaration for the resource class.

import com.example.dao.PersonDAO; // Importing PersonDAO for database operations.
import com.example.model.Person; // Importing Person model.
import java.util.List; // Importing List for handling collections.

import javax.ws.rs.*; // Importing JAX-RS annotations.
import javax.ws.rs.core.MediaType; // Importing MediaType for specifying content types in HTTP requests and responses.
import javax.ws.rs.core.Response; // Importing Response for building HTTP responses.

@Path("/persons") // Annotation specifying the base path for this resource.
@Produces(MediaType.APPLICATION_JSON) // Annotation specifying that this resource produces JSON responses.
@Consumes(MediaType.APPLICATION_JSON) // Annotation specifying that this resource consumes JSON requests.
public class PersonResource { // Declaration of PersonResource class.

    private static final PersonDAO personDAO = new PersonDAO(); // Initialization of PersonDAO for database operations.

    @GET // HTTP GET method annotation for retrieving data.
    public Response getAllPersons() { // Method for retrieving all persons.
        List<Person> persons = personDAO.getAllPersons(); // Retrieving all persons from the database.
        return Response.ok(persons).build(); // Returning OK response with the list of persons.
    }

    @GET // HTTP GET method annotation for retrieving data.
    @Path("/{id}") // Annotation specifying additional path for this method.
    public Response getPerson(@PathParam("id") int id) { // Method for retrieving a person by ID.
        try {
            Person person = personDAO.getPerson(id); // Retrieving person by ID from the database.
            return Response.ok(person).build(); // Returning OK response with the retrieved person.
        } catch (NotFoundException e) { // Catching NotFoundException if the person is not found.
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build(); // Returning NOT_FOUND response with error message.
        }
    }

    @POST // HTTP POST method annotation for creating data.
    public Response addPerson(Person person) { // Method for adding a new person.
        personDAO.addPerson(person); // Adding the new person to the database.
        return Response.status(Response.Status.CREATED).entity(person).build(); // Returning CREATED response with the added person.
    }

    @PUT // HTTP PUT method annotation for updating data.
    @Path("/{id}") // Annotation specifying additional path for this method.
    public Response updatePerson(@PathParam("id") int id, Person updatedPerson) { // Method for updating a person by ID.
        try {
            personDAO.updatePerson(id, updatedPerson); // Updating the person in the database.
            return Response.ok().build(); // Returning OK response.
        } catch (NotFoundException e) { // Catching NotFoundException if the person is not found.
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build(); // Returning NOT_FOUND response with error message.
        }
    }

    @DELETE // HTTP DELETE method annotation for deleting data.
    @Path("/{id}") // Annotation specifying additional path for this method.
    public Response deletePerson(@PathParam("id") int id) { // Method for deleting a person by ID.
        try {
            personDAO.deletePerson(id); // Deleting the person from the database.
            return Response.ok().build(); // Returning OK response.
        } catch (NotFoundException e) { // Catching NotFoundException if the person is not found.
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build(); // Returning NOT_FOUND response with error message.
        }
    }
}
