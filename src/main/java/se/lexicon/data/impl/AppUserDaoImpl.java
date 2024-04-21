package se.lexicon.data.impl;

import se.lexicon.data.AppUserDao;
import se.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class AppUserDaoImpl implements AppUserDao {

    private List <AppUser> usersCollection;

    public AppUserDaoImpl() {
        this.usersCollection = new ArrayList<>();

     }


        @Override
    public AppUser persist(AppUser user) {
        //Null check
            if (user == null) throw new IllegalArgumentException("Data is empty");
        //Double check
            Optional<AppUser> existingAppUser = findByUserName(user.getUsername());
            if (existingAppUser.isPresent()) {
                throw new IllegalArgumentException("User is duplicate");
            }
        //Add user to collection
        usersCollection.add(user);

            return user;
        }

    @Override
    public Optional<AppUser> findByUserName(String email) {
        // Search for the user by email
        for (AppUser user : usersCollection){
            if(user.getUsername().equals(email)){
                return Optional.of(user);
            }

        }
        return Optional.empty();
    }

    @Override
    public Collection<AppUser> findAll() {
        //Return all users in the collection
        return  new ArrayList<>(usersCollection);
    }

    @Override
    public boolean remove(String userName) {
        //Remove a user from Collection
        for (AppUser user : usersCollection){
            if(user.getUsername().equals(userName));{
                usersCollection.remove(user);
                return true;
            }
        }
        return false;
    }
}
