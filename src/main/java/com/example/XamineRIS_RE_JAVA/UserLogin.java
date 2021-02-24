package com.example.XamineRIS_RE_JAVA;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;


public class UserLogin {
    final String uriString = "mongodb+srv://cwimpy55:lN57HJ^kvHgtLMTQjWSU8H@cluster0.ptuiv.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
    MongoClient mongoClient = MongoClients.create(uriString);

    MongoDatabase db = MongoClients.create().getDatabase("accounts_users");
    MongoCollection<Document> collection = db.getCollection("users");

    Iterable findIterable;

    public Administrator logginAttempt (String username, String password){
        findIterable = collection.find(and(eq("username", username),eq("password", password)));

        String uName;
        String pWord;

        Administrator admin = new Administrator(username, password);
        Consumer<Document> printConsumer = new Consumer<Document>() {
            @Override
            public void accept(Document document) {
                System.out.println(document.toJson());
            }
        };

        return admin;
    }
}
