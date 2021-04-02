package com.example.XamineRIS_RE_JAVA;

import com.mongodb.client.*;
import org.bson.BsonDateTime;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;
import com.example.XamineRIS_RE_JAVA.*;

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
}
