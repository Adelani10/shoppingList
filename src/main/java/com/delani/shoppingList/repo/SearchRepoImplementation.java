package com.delani.shoppingList.repo;


import com.delani.shoppingList.model.Item;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImplementation implements SearchRepository {

  @Autowired
  MongoClient client;

  @Autowired
  MongoConverter converter;

  @Override
  public List<Item> findByKeyword(String keyword) {
    final List<Item> items = new ArrayList<>();

    MongoDatabase database = client.getDatabase("Grocery");
    MongoCollection<Document> collection = database.getCollection("ItemsCollection");
    AggregateIterable<Document> result = collection.aggregate(Arrays.asList
        (new Document("$search",
            new Document("index", "default")
                .append("text",
                    new Document("query",keyword)
                        .append("path", Arrays.asList("name", "note", "category")))),
        new Document("$limit", 5L)));

    result.forEach(doc -> items.add(converter.read(Item.class, doc)));
    return items;
  }
}
