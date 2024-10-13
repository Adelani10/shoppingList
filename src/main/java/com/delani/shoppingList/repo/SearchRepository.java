package com.delani.shoppingList.repo;

import com.delani.shoppingList.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SearchRepository  {
  List<Item> findByKeyword(String keyword);
}
