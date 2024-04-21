package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserDaoImplTest {
    private AppUserDaoImpl testObject;


    @BeforeEach
    public void setUp() {
        testObject = new AppUserDaoImpl(); // Initialize test object before each test
    }

    @Test
    public void testCreateAppUser(){
        AppUser appUser = new AppUser("Username1","12345", AppUser.Role.ROLE_APP_ADMIN);

        // Persist the AppUser
        testObject.persist(appUser);
        // Retrieve the persisted AppUser
        AppUser persistedUser = testObject.findByUserName("Username1").orElse(null);
        // Assert that the retrieved user is the same as the one persisted
        assertEquals(appUser, persistedUser);
    }

    @Test
    public void testFindByUserName(){
        AppUser appUser = new AppUser("Username1","12345", AppUser.Role.ROLE_APP_ADMIN);
        // Persist the AppUser
        testObject.persist(appUser);
        // Retrieve the persisted AppUser
        AppUser persistedUser = testObject.findByUserName("Username1").orElse(null);
        assertEquals("Username1",persistedUser.getUsername());


    }
    @Test
    public void testFindAll(){
        testObject.persist(new AppUser("Username1","12345", AppUser.Role.ROLE_APP_ADMIN));
        testObject.persist(new AppUser("Username2","23456", AppUser.Role.ROLE_APP_USER));
        testObject.persist(new AppUser("Username3","34567", AppUser.Role.ROLE_APP_ADMIN));
        testObject.persist(new AppUser("Username4","45678", AppUser.Role.ROLE_APP_USER));

        // Retrieve all persisted AppUsers
        Collection<AppUser> allUsers = testObject.findAll();


        assertEquals(4,allUsers.size());


    }
    @Test
    public void testRemove(){
        // Create a new AppUser and persist it
        AppUser appUser = new AppUser("Username1", "12345", AppUser.Role.ROLE_APP_USER);
        testObject.persist(appUser);

        // Remove the persisted AppUser
        boolean removed = testObject.remove("Username1");

        // Assert that the removal was successful
        assertTrue(removed);
        assertFalse(testObject.findByUserName("Username1").isPresent());
    }

}
