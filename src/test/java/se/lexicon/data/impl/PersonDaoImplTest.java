package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Person;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


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
        // Add some persons to the dao
        Person person1 = new Person(1,"Jane","Kirby","email@test");
        Person person2 = new Person(2,"John","Doe","test@email");
        testObject.persist(person1);
        testObject.persist(person2);

        // Retrieve all persons
        Collection<Person> allPersons = testObject.findAll();

        // Assert that the number of retrieved persons matches the number of persisted persons
        assertEquals(2, allPersons.size());
        assertTrue(allPersons.contains(person1));
        assertTrue(allPersons.contains(person2));
    }

    @Test
    public void testRemovePerson() {
        // Add a person to the dao
        Person person = new Person(1,"John","Doe","test@test");
        testObject.persist(person);

        // Remove the person
        assertTrue(testObject.remove(person.getId()));

        // Assert that the person has been removed
        assertFalse(testObject.findById(person.getId()).isPresent());

    }


    }




