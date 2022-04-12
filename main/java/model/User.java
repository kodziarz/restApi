package model;

import com.fasterxml.uuid.Generators;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public void generateId(){
        this.id = Generators.randomBasedGenerator().generate().toString();
    }

    public String getId() {
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
