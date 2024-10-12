package com.delani.shoppingList.repo;

import com.delani.shoppingList.model.Item;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, ObjectId> {
  List<Item> findByKeyword(String keyword);
}
