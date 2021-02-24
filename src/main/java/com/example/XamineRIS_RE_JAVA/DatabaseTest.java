package com.example.XamineRIS_RE_JAVA;

import com.mongodb.Block;
import com.mongodb.client.*;
import org.bson.Document;


import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class DatabaseTest {
     public static void main(String[] args) {
        final String uriString = "mongodb+srv://cwimpy55:lN57HJ^kvHgtLMTQjWSU8H@cluster0.ptuiv.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(uriString);

        MongoDatabase mongoDB = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = mongoDB.getCollection("inventory");

       collection.insertMany(asList(
               Document.parse("{ item: 'journal', qty: 25, size: { h: 14, w: 21, uom: 'cm' }, status: 'A' }"),
               Document.parse("{ item: 'notebook', qty: 50, size: { h: 8.5, w: 11, uom: 'in' }, status: 'A' }"),
               Document.parse("{ item: 'paper', qty: 100, size: { h: 8.5, w: 11, uom: 'in' }, status: 'D' }"),
               Document.parse("{ item: 'planner', qty: 75, size: { h: 22.85, w: 30, uom: 'cm' }, status: 'D' }"),
               Document.parse("{ item: 'postcard', qty: 45, size: { h: 10, w: 15.25, uom: 'cm' }, status: 'A' }")
       ));

       Iterable findIterable = collection.find(eq("status", "D"));

       Consumer<Document> printConsumer = new Consumer<Document>() {
           @Override
           public void accept(Document document) {
               System.out.println(document.toJson());
           }
       };

       findIterable.forEach(printConsumer);

       mongoClient.close();
    }
}
