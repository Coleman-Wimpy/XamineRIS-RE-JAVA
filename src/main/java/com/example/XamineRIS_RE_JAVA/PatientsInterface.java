package com.example.XamineRIS_RE_JAVA;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;

public interface PatientsInterface {

    final String uriString = "mongodb+srv://cwimpy55:lN57HJ^kvHgtLMTQjWSU8H@cluster0.ptuiv.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

    // Create a MongoClient object using the uri above
    MongoClient mongoClient = MongoClients.create(uriString);

    // Creates a Database object using the accounts_users database
    MongoDatabase db = mongoClient.getDatabase("RISData");
    // Creates a collection object that holds the users collection from the database that was loaded
    MongoCollection<Document> collection = db.getCollection("patients");

    default BsonDocument getPatients(String firstName, String lastName) {


        Iterable findIterable = collection.find(eq("firstName", firstName));

        if (findIterable == null) {
            return null;
        }
        else {
            final BsonDocument[] bsonDocuments = new BsonDocument[1];

            Consumer<Document> printConsumer = new Consumer<Document>() {
                @Override
                public void accept(Document document) {
                    bsonDocuments[0] = document.toBsonDocument();
                }
            };

            findIterable.forEach(printConsumer);

            return bsonDocuments[0];
        }
    }
}
