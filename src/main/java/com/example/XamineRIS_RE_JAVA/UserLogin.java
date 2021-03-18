package com.example.XamineRIS_RE_JAVA;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.json.Json;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;

import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;

// Class that will hold the methods to try and login a user and verify the username and password
// and direct the user to the correct corresponding page
public interface UserLogin {
    // store the uri of the mongoDB server that will be used
    final String uriString = "mongodb+srv://cwimpy55:lN57HJ^kvHgtLMTQjWSU8H@cluster0.ptuiv.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

    // Create a MongoClient object using the uri above
    MongoClient mongoClient = MongoClients.create(uriString);

    // Creates a Database object using the accounts_users database
    MongoDatabase db = mongoClient.getDatabase("accounts_users");
    // Creates a collection object that holds the users collection from the database that was loaded
    MongoCollection<Document> collection = db.getCollection("users");

    // Initializes an Iterable object


    // Method that will be used in the login servlet class to pass the username and password that was entered
    // then the variables will be checked to see if they are in the database and what role that user has
    default BsonDocument loginAttempt(String username, String password){
        // assign findIterable to any object found in the databse that the username and password both match an object in the database
        Iterable findIterable = collection.find(and(eq("username", username),eq("password", password)));

        if (findIterable == null) {
            return null;
        }
        else {
            final BsonDocument[] bsonDocument = new BsonDocument[1];


            //print the json object that is retrieved from the database
            Consumer<Document> printConsumer = new Consumer<Document>() {
                @Override
                public void accept(Document document) {
                    bsonDocument[0] = document.toBsonDocument();
                    //String uName = bsonDocument[0].getString("username").getValue();
                    //String pWord = bsonDocument[0].getString("password").getValue();
                    //int groupId = bsonDocument[0].getInt32("groupId").getValue();
                }
            };

            findIterable.forEach(printConsumer);

            return bsonDocument[0];
        }
    }
}
