package se.lexicon;

public class TodoItemTask {

    private static int nextId = 1;
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;
    // Constructors
    public TodoItemTask(int id, boolean assigned, TodoItem todoItem, Person assignee) {
        this.id = id;
        this.assigned = assigned;
        this.todoItem = todoItem;
        this.assignee = assignee;
    }

    public TodoItemTask(int id, boolean assigned, String createAWebsite, String person1) {
    }

    public TodoItemTask(Person assignee){
        this.assignee = getAssignee();
        this.todoItem = getTodoItem();
    }

    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this.id = id;
        this.todoItem = todoItem;
        this.assignee = assignee;
        this.assigned = (assignee != null);
    }

    public TodoItemTask() {

    }

    //Getters


    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    // Setters

    public static void setNextId(int nextId) {
        TodoItemTask.nextId = nextId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null) throw new IllegalArgumentException("This field should not be empty .");
        this.todoItem = todoItem;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned = assignee !=null;
    }

    public String getSummary(){
        return "Todo Item Task : " +"Id : " + id +
                " Item :" + todoItem.getSummary() +
                "Assignee : " + assignee.getSummary()  +
                " Assigned : " + assigned;
    }



    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +
                ", assignee=" + assignee +
                '}';
    }
}
