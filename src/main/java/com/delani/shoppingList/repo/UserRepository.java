package com.delani.shoppingList.repo;

import com.delani.shoppingList.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
