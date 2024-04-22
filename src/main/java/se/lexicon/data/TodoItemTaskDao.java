package se.lexicon.data;

import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface TodoItemTaskDao {
    //persist: add new TodoItemTask.class object to collection
    TodoItemTask persist(TodoItemTask todoItemTask);

    Optional<TodoItemTask> findById(int id);//findById: returns single TodoItem task

    Collection<TodoItemTask> findAll();//findAll: returns all TodoItemTask objects

    //findByAssignedStatus: return all TodoItemTask.class objects where
           // assigned matches status
    Collection<TodoItemTask> findAllByAssignedStatus (boolean assigned);


    //findByPersonId: returns many
    //TodoItemTask.class objects where personId
    //match todoItem.creator.id
    Collection<TodoItemTask>findByPersonId(int personId);

    //remove: remove one TodoItemTask.class object
    //from collection
    boolean remove(int id);
}
