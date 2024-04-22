package se.lexicon.data.impl;

import se.lexicon.data.TodoItemTaskDao;
import se.lexicon.data.sequencer.TodoItemTaskIdSequencer;
import se.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class TodoItemTaskDaoImpl implements TodoItemTaskDao {

    List<TodoItemTask> todoItemTaskList;

    public TodoItemTaskDaoImpl() {
        this.todoItemTaskList = new ArrayList<>();
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        //Check null
        if (todoItemTask == null) throw new IllegalArgumentException("Data is null");
        //Set Id
        int id = TodoItemTaskIdSequencer.nextId();
        todoItemTask.setId(id);
        //Check Optional
        //find by id
        Optional<TodoItemTask> optionalTodoItemTask = findById(todoItemTask.getId());
        //4.condition if is a duplicate - if is duplicate
        if(optionalTodoItemTask.isPresent()) throw new IllegalArgumentException("Id is duplicate");
        // Add task
        todoItemTaskList.add(todoItemTask);
        //return task
        return todoItemTask;
    }

    @Override
    public Optional<TodoItemTask> findById(int id) {
        for (TodoItemTask task : todoItemTaskList){
            if (task.getId() == id)
                return Optional.of(task);
        }
        return Optional.empty();
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTaskList);
    }

    @Override
    public Collection<TodoItemTask> findAllByAssignedStatus(boolean assigned) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task : todoItemTaskList){
            if (task.isAssigned() == assigned){
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        //Create a new empty List
        List<TodoItemTask> result = new ArrayList<>();
        //Iterate and check
        for (TodoItemTask task : todoItemTaskList){
            if(task.getAssignee().equals(personId)){
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public boolean remove(int id) {
        for (TodoItemTask task : todoItemTaskList){
            if (task.getId() == id);
            todoItemTaskList.remove(task);
            return true;
        }
        return false;
    }
}
