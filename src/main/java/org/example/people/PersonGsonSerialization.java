package org.example.people;

import com.google.gson.Gson;

public class PersonGsonSerialization implements  PersonSerializationService{
    @Override
    public String SerializePerson(Owner owner) {
        Gson gson = new Gson();
        return gson.toJson(owner, Owner.class);
    }
}
