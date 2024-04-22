package se.lexicon.data.impl;

import se.lexicon.data.TodoItemDao;
import se.lexicon.data.sequencer.TodoItemIdSequencer;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class TodoItemDaoImpl implements TodoItemDao {

    private List<TodoItem> todoItemList;

    public TodoItemDaoImpl() {
        this.todoItemList = new ArrayList<>();
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        //1.Null check
        if(todoItem == null) throw new IllegalArgumentException("Data base is null.");
        //2.set id
        int id = TodoItemIdSequencer.nextId();
        todoItem.setId(id);
        //3.Duplicate check - Optional
        Optional<TodoItem> optionalTodoItem = findById(todoItem.getId());
        //4.condition if is a duplicate
        if(optionalTodoItem.isPresent()) throw new IllegalArgumentException("Duplicate id.");
        //Add to item to the list
        todoItemList.add(todoItem);
        // return
        return todoItem;
    }

    @Override
    public Optional<TodoItem> findById(int id) {
        //Check to the list
        for (TodoItem item : todoItemList){
            if(item.getId() == id){
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItemList);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean doneStatus) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItemList){
            if (item.isDone() == doneStatus)
                result.add(item);
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItemList){
            if (item.getTitle() == title){
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item :todoItemList){
            if(item.getCreator().equals(personId)){
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItemList){
            if (item.getDeadLine().isBefore(date)){
                result.add(item);
            }

        }
        return result;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItemList){
            if (item.getDeadLine().isAfter(date)){
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public boolean remove(int id) {
        for (TodoItem item : todoItemList){
            if (item.getId() == id){
                todoItemList.remove(item);
                return true;
            }
        }
        return false;
    }
}
