package org.example.people;

import com.google.inject.Singleton;

@Singleton
public class OwnerJsonSerializationService implements PersonSerializationService {
    public String SerializePerson (Owner owner) {
        StringBuilder builder = new StringBuilder();
        builder.append("\"name\": " + "\"" + String.format((owner.firstname))+"\""+"\n");
        builder.append("\"surname\": " + "\"" + String.format((owner.lastname))+"\""+"\n");
        builder.append("\"personalID\": " + "\"" + String.format((owner.personalId))+"\""+"\n");

        return builder.toString();

    }
}
