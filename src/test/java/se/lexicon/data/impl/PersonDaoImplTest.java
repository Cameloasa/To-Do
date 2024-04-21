package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Person;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//Create a New Person: Instantiate a new Person object with some sample data.
//Add the Person: Call the persist method of your DAO implementation to add the person to the collection.
//Retrieve the Added Person: Use the findById method to retrieve the added person.
//Assertion: Assert that the retrieved person is present (Optional.isPresent()) and matches the expected person.

public class PersonDaoImplTest {
    private PersonDaoImpl testObject;


    @BeforeEach
    public void setUp() {
        testObject = new PersonDaoImpl(); // Initialize test object before each test
    }

    @Test
    public void testCreatePerson() {
        // create a new person
        Person person = new Person(1, "John", "Doe", "test@test");

        //Add the user
        testObject.persist(person);
        // Retrieve the added Person
        Optional<Person> actualValue = testObject.findById(1);

        assertTrue(actualValue.isPresent());
        assertEquals(person, actualValue.get());

    }
    @Test
    public void testPersonFindById(){
        //Create a New Person: Instantiate a new Person object with some sample data.
        Person person = new Person(1, "John", "Doe","test@test");
       //Add the Person: Call the persist method of your DAO implementation to add the person to the collection.
        testObject.persist(person);
        //Retrieve the Added Person: Use the findById method to retrieve the added person.
        Optional<Person> actualValue = testObject.findById(1);
        //Assertion: Assert that the retrieved person is present (Optional.isPresent()) and matches the expected person.
        assertTrue( actualValue.isPresent());
        assertEquals(person, actualValue.get());
    }
    @Test
    public void testPersonFindByEmail(){
    //Create a New Person: Instantiate a new Person object with some sample data.
        Person person = new Person(1, "John", "Doe","test@test");
        //Add the Person: Call the persist method of your DAO implementation to add the person to the collection.
        testObject.persist(person);
        //Retrieve the Added Person: Use the findById method to retrieve the added person
        Optional<Person> actualValue = testObject.findByEmail("test@test");
        //Assertion: Assert that the retrieved person is present (Optional.isPresent()) and matches the expected person.
        assertTrue(actualValue.isPresent());
        assertEquals(person,actualValue.get());
    }
    @Test
    public void testPersonFindAll(){

    }
    @Test
    public void testRemovePerson(){

    }



}
