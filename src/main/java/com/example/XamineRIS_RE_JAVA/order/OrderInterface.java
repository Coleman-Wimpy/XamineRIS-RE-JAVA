package com.example.XamineRIS_RE_JAVA.order;

import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;

public interface OrderInterface {

    final String uriString = "mongodb+srv://cwimpy55:lN57HJ^kvHgtLMTQjWSU8H@cluster0.ptuiv.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

    // Create a MongoClient object using the uri above
    MongoClient mongoClient = MongoClients.create(uriString);

    // Creates a Database object using the accounts_users database
    MongoDatabase db = mongoClient.getDatabase("RISData");
    // Creates a collection object that holds the users collection from the database that was loaded
    MongoCollection<Document> collection = db.getCollection("orders");



    default Boolean createOrder(Document order) {

        FindIterable<Document> iterable = collection.find(gte("numberOfOrders", 0));

        ArrayList<Integer> orderNumber = new ArrayList<>();
        final Document[] orderNumDoc = new Document[1];

        Consumer<Document> printConsumer = new Consumer<Document>() {
            @Override
            public void accept(Document document) {
                orderNumber.add(document.getInteger("numberOfOrders"));
                orderNumDoc[0] = document;
            }
        };

        iterable.forEach(printConsumer);

        int orderNum = orderNumber.get(0).intValue();
        orderNum++;
        order.append("orderNumber", orderNum);

        if (collection.insertOne(order).wasAcknowledged()){
            collection.updateOne(gte("numberOfOrders", 0), Updates.set("numberOfOrders", orderNum));
            return true;
        }

        return false;
    }

    default Integer getOrderNumber() {
        FindIterable<Document> iterable = collection.find(gte("numberOfOrders", 0));

        ArrayList<Integer> orderNumber = new ArrayList<>();
        final Document[] orderNumDoc = new Document[1];

        Consumer<Document> printConsumer = new Consumer<Document>() {
            @Override
            public void accept(Document document) {
                orderNumber.add(document.getInteger("numberOfOrders"));
                orderNumDoc[0] = document;
            }
        };

        iterable.forEach(printConsumer);

        int orderNum = orderNumber.get(0).intValue();

        return orderNum++;
    }


    default ArrayList<Document> getOrders(String firstName, String lastName, String dob) {

        FindIterable<Document> findIterable = collection.find(and(eq("firstName", firstName), eq("lastName", lastName), eq("DOB", dob)));

        if (findIterable == null) {
            System.out.println("No Orders Found");
            return null;
        } else {
            ArrayList<Document> bdocuments = new ArrayList<>();

            Consumer<Document> printConsumer = new Consumer<Document>() {
                @Override
                public void accept(Document document) {
                    bdocuments.add(document);
                    System.out.println("Found Order");
                }
            };

            findIterable.forEach(printConsumer);

            return bdocuments;
        }
    }

    default ArrayList<Document> getCheckedInOrders() {

        FindIterable<Document> findIterable = collection.find(eq("status", "Checked In"));

        if (findIterable == null) {
            System.out.println("No Orders Found");
            return null;
        } else {
            ArrayList<Document> bdocuments = new ArrayList<>();

            Consumer<Document> printConsumer = new Consumer<Document>() {
                @Override
                public void accept(Document document) {
                    bdocuments.add(document);
                    System.out.println("Found Order");
                }
            };

            findIterable.forEach(printConsumer);

            return bdocuments;
        }
    }


        default ArrayList<Document> getOrder ( int orderNum){

            FindIterable<Document> orderIterable = collection.find(eq("orderNumber", orderNum));

            if (orderIterable == null) {
                System.out.println("No Orders Found");
                return null;
            } else {
                ArrayList<Document> bdocuments = new ArrayList<>();

                Consumer<Document> printConsumer = new Consumer<Document>() {
                    @Override
                    public void accept(Document document) {
                        bdocuments.add(document);
                        System.out.println("Found Order");
                    }
                };

                orderIterable.forEach(printConsumer);

                return bdocuments;
            }
        }


        default Boolean updateOrderStatus(String status, int  orderNum) {

            if (collection.updateOne(eq("orderNumber", orderNum), Updates.set("status", status)).wasAcknowledged())
                return true;

            return false;
        }

        //default Boolean addImage(String filePath, String fileName, int orderNum) {}
        default ArrayList<Document> getWaitingOrders() {

            FindIterable<Document> findIterable = collection.find(eq("status", "Waiting Review"));

            if (findIterable == null) {
                System.out.println("No Orders Found");
                return null;
            } else {
                ArrayList<Document> bdocuments = new ArrayList<>();

                Consumer<Document> printConsumer = new Consumer<Document>() {
                    @Override
                    public void accept(Document document) {
                        bdocuments.add(document);
                        System.out.println("Found Order");
                    }
                };

                findIterable.forEach(printConsumer);

                return bdocuments;
            }
        }
    }


