package com.delani.shoppingList.repo;


import com.delani.shoppingList.model.UserSavedHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSavedHistoryRepository extends MongoRepository<UserSavedHistory, String> {
}
