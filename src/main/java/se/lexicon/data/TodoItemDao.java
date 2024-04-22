package se.lexicon.data;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface TodoItemDao {
    //persist: add new TodoItem.class object to
    //collection
    TodoItem persist(TodoItem todoItem);


    Optional<TodoItem> findById(int id);//findById: returns single TodoItem

    Collection<TodoItem> findAll();//findAll: returns all TodoItem objects

    //find by done status returns manyTodoItem.class objects where status match
    Collection<TodoItem> findAllByDoneStatus (boolean doneStatus);
    //findByTitleContains: returns many
    //TodoItem.class objects where title match.
    Collection<TodoItem>findByTitleContains(String title);
    //findByPersonId: returns many
    //TodoItem.class objects where personId
    //match todoItem.creator.id
    Collection<TodoItem>findByPersonId(int personId);
    //findByDeadlineBefore: returns many
    //TodoItem.class objects where date is before
    //deadline
    Collection<TodoItem>findByDeadlineBefore(LocalDate date);
    //findByDeadlineAfter: returns many
    //TodoItem.class objects where date is after
    //deadline
    Collection<TodoItem>findByDeadlineAfter(LocalDate date);
    //remove: remove one TodoItem.class object
    //from collection
    boolean remove(int id);
}
