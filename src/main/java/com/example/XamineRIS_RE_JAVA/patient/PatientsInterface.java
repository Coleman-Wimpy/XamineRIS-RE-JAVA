package com.example.XamineRIS_RE_JAVA.patient;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public interface PatientsInterface {

    final String uriString = "mongodb+srv://cwimpy55:lN57HJ^kvHgtLMTQjWSU8H@cluster0.ptuiv.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

    // Create a MongoClient object using the uri above
    MongoClient mongoClient = MongoClients.create(uriString);

    // Creates a Database object using the accounts_users database
    MongoDatabase db = mongoClient.getDatabase("RISData");
    // Creates a collection object that holds the users collection from the database that was loaded
    MongoCollection<Document> collection = db.getCollection("patients");

    default Boolean createPatient(Document doc) {
        if (collection.insertOne(doc).wasAcknowledged())
            return true;
       else
           return false;
    }

    default ArrayList<Document> getPatients(String dob) {

        FindIterable<Document> findIterable = collection.find(eq("DOB", dob));

        if (findIterable == null) {
            System.out.println("No objects found");
            return null;
        }
        else {
            ArrayList<Document> bdocuments = new ArrayList<>();

            Consumer<Document> printConsumer = new Consumer<Document>() {
                @Override
                public void accept(Document document) {
                   bdocuments.add(document);
                }
            };

            findIterable.forEach(printConsumer);

            return bdocuments;
        }
    }

    default ArrayList<Document> getPatient(String firstName, String lastName) {

        FindIterable<Document> findIterable = collection.find(and(eq("firstName", firstName), (eq("lastName", lastName))));

        if (findIterable == null) {
            System.out.println("No objects found");
            return null;
        }
        else {
            ArrayList<Document> bdocuments = new ArrayList<>();

            Consumer<Document> printConsumer = new Consumer<Document>() {
                @Override
                public void accept(Document document) {
                    bdocuments.add(document);
                }
            };

            findIterable.forEach(printConsumer);

            return bdocuments;
        }
    }
}
