package org.example.people;

public class Owner {
    public String firstname;
    public String lastname;
    public int personalId;

    public Owner(String firstname, String lastname,int personalId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.personalId = personalId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
