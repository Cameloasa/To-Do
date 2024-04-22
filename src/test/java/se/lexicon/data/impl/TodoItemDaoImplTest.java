package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemDaoImplTest {

    private TodoItemDaoImpl testObject;

    @BeforeEach
    void setUp() {
        // Initialize the test object before each test
        testObject = new TodoItemDaoImpl();
    }
    //Create a New todoItem: Instantiate a new todoItem object with some sample data.
    //Add the todoItem: Call the persist method of your DAO implementation to add the todoItem to the collection.
    //Retrieve the Added todoItem: Use the findById method to retrieve the added todoItem.
    //Assertion: Assert that the retrieved todoItem is present (Optional.isPresent()) and matches the expected todoItem.
    @Test
    void persist() {
        //Create a New todoItem:
        TodoItem item = new TodoItem(1,"Java","Test unit", LocalDate.of(2024,04,24),true);
        //Add the todoItem: Call the persist method
        testObject.persist(item);
        //Optional actual value =
        //Retrieve the Added todoItem: Use the findById method
        Optional<TodoItem> actualValue = testObject.findById(1);
        //Assertion: Assert that the retrieved todoItem is present (Optional.isPresent())
        assertTrue(actualValue.isPresent());
        assertEquals(actualValue.get(),item);
    }

    @Test
    void findById() {
        //Create a New todoItem:
        TodoItem item = new TodoItem(1,"Java","Test unit", LocalDate.of(2024,04,24),true);
        //Add the item calling persist method
        testObject.persist(item);
        // Use Optional and find by id
        Optional<TodoItem> actualValue = testObject.findById(1);
        // assert true if the item is present
        assertTrue(actualValue.isPresent());
    }

    @Test
    void findAll() {
    }

    @Test
    void findAllByDoneStatus() {
    }

    @Test
    void findByTitleContains() {
    }

    @Test
    void findByPersonId() {
    }

    @Test
    void findByDeadlineBefore() {
    }

    @Test
    void findByDeadlineAfter() {
    }

    @Test
    void remove() {
    }
}