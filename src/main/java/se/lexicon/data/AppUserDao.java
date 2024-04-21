package se.lexicon.data;

import se.lexicon.model.AppUser;

import java.util.Collection;
import java.util.Optional;

public interface AppUserDao {
    AppUser persist(AppUser user);
    Optional<AppUser> findByUserName(String email);
    Collection<AppUser> findAll();
    boolean remove(String userName);


}
