package se.lexicon.data.impl;

import se.lexicon.data.PersonDao;
import se.lexicon.data.sequencer.PersonIdSequencer;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static se.lexicon.data.sequencer.PersonIdSequencer.*;

public class PersonDaoImpl implements PersonDao {

    private List<Person> personList;

    public PersonDaoImpl() {
        this.personList = new ArrayList<>();
    }

    @Override
    public Person persist(Person person) {
        //Null check
        if (person == null ) throw new IllegalArgumentException("Data cannot be null");
        //Set id
        int id = PersonIdSequencer.nextId();
        person.setId(id);
        // Duplicate check (optional)
        Optional<Person> existingPerson = findById(person.getId());
        if (existingPerson.isPresent()) throw new IllegalArgumentException("Person Id is duplicate");
        //Add Person to personList
        personList.add(person);
        return person;
    }

    @Override
    public Optional<Person> findById(int id) {
        for (Person person : personList){
            if (person.getId() == id){
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }


    @Override
    public Optional<Person> findByEmail(String email) {
        for (Person person : personList){
            if (person.getEmail().equals(email)){
                return Optional.of(person);
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(personList);
    }

    @Override
    public boolean remove(int id) {
        //Remove a user from Collection
        for (Person person : personList){
            if (person.getId() == id){
                personList.remove(person);
                return true;

            }

        }

        return false;
    }
}
