package com.example.dao; // Package declaration for the DAO class.

import com.example.model.Person; // Importing Person model.

import java.util.List; // Importing List for handling collections.
import java.util.ArrayList; // Importing ArrayList for storing persons.
import java.util.concurrent.atomic.AtomicInteger; // Importing AtomicInteger for generating unique IDs.
import javax.ws.rs.NotFoundException; // Importing NotFoundException for handling not found exceptions.

public class PersonDAO { // Declaration of PersonDAO class.
    private static final List<Person> persons = new ArrayList<>(); // Initializing list to store persons.
    private static final AtomicInteger nextId = new AtomicInteger(1); // Initializing atomic integer for generating unique IDs.

    static {
        // Initialize with dummy data
        persons.add(new Person(nextId.getAndIncrement(), "John Doe", "Male", "1234 Elm Street", 30)); // Adding dummy person data.
        persons.add(new Person(nextId.getAndIncrement(), "Jane Doe", "Female", "5678 Oak Street", 25)); // Adding dummy person data.
        persons.add(new Person(nextId.getAndIncrement(), "Alice Johnson", "Female", "91011 Maple Street", 28)); // Adding dummy person data.
    }

    public List<Person> getAllPersons() { // Method to get all persons.
        return persons; // Returning the list of persons.
    }

    public void addPerson(Person person) { // Method to add a new person.
        person.setID(nextId.getAndIncrement()); // Ensuring a unique ID is set.
        persons.add(person); // Adding the person to the list.
    }

    public Person getPerson(int id) { // Method to get a person by ID.
        return persons.stream() // Streaming over the list of persons.
                      .filter(p -> p.getID() == id) // Filtering by ID.
                      .findFirst() // Finding the first matching person.
                      .orElse(null); // Returning null if not found.
    }

    public void updatePerson(int id, Person updatedPerson) throws NotFoundException { // Method to update a person by ID.
        Person person = getPerson(id); // Getting the person by ID.
        person.setName(updatedPerson.getName()); // Updating name.
        person.setGender(updatedPerson.getGender()); // Updating gender.
        person.setAddress(updatedPerson.getAddress()); // Updating address.
        person.setAge(updatedPerson.getAge()); // Updating age.
    }

    public void deletePerson(int id) throws NotFoundException { // Method to delete a person by ID.
        Person person = getPerson(id); // Getting the person by ID.
        persons.remove(person); // Removing the person from the list.
    }
}
