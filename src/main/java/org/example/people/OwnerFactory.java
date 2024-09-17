package org.example.people;

public class OwnerFactory {
    public Owner getNewOwner(String firstName, String lastName, int persnalId) {
        return new Owner(firstName,lastName,persnalId);
    }
}
