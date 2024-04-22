package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskDaoImplTest {

    private TodoItemTaskDaoImpl testObject;

    @BeforeEach
    void setUp() {
        // Initialize the test object before each test
        testObject = new TodoItemTaskDaoImpl();

    }

    @Test
    void persist() {
        //Create a New todoItem task:
        TodoItemTask task = new TodoItemTask(1, true,"Make an application","Teacher");
        //Add the task: Call the persist method
        testObject.persist(task);
        //Optional actual value =
        //Retrieve the Added task: Use the findById method
        Optional<TodoItemTask> actualValue = testObject.findById(1);
        //Assertion: Assert that the retrieved todoItem is present (Optional.isPresent())
        assertTrue(actualValue.isPresent());
        assertEquals(actualValue.get(),task);
    }

    @Test
    void findById() {
        // create a new task
        TodoItemTask task = new TodoItemTask(1,true,"Java","Student");
        //Add the task using persist
        testObject.persist(task);
        //create an Optional(actual Value) and use find by id method
        Optional actualValue = testObject.findById(1);
        //assert true using is present
        assertTrue(actualValue.isPresent());
    }

    @Test
    void findAll() {
    }

    @Test
    void findAllByAssignedStatus() {
    }

    @Test
    void findByPersonId() {
    }

    @Test
    void remove() {
    }
}