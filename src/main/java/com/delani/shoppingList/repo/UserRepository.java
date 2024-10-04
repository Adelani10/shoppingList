package com.delani.shoppingList.repo;

import com.delani.shoppingList.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
  User findByUsername(String username);
}
