package se.lexicon;

public class Person {

    // Fields
    private static int nextId = 1;
    private int id;
    private String firstName; // not allowed to be null
    private String lastName; // not allowed to be null
    private String email; // not allowed to be null

    //Constructors
    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public static int getNextId() {
        return nextId++;
    }
    //Setters
    public void setFirstName(String firstName) {
        if(firstName == null) throw new IllegalArgumentException("This field should not be nul");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {if(firstName == null) throw new IllegalArgumentException("This field should not be nul");
        if(lastName == null) throw new IllegalArgumentException("This field should not be nul");
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if(email == null) throw new IllegalArgumentException("This field should not be nul");
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    // Method for getSummary
    public String getSummary(){
        return "Person info :" + "Id :" + id + " First name : " + firstName + ", Last name :" + lastName + " email :" + email;

    }


}
