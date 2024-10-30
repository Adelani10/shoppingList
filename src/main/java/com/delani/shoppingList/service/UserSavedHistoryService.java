package com.delani.shoppingList.service;

import com.delani.shoppingList.model.User;
import com.delani.shoppingList.model.UserSavedHistory;
import com.delani.shoppingList.repo.UserRepository;
import com.delani.shoppingList.repo.UserSavedHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserSavedHistoryService {

  @Autowired
  UserSavedHistoryRepository userSavedHistoryRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserService userService;

  public void addToHistory(UserSavedHistory userSavedHistory) {
    User user = userService.getCurrentUser();
    userSavedHistory.setUserId(user.getUserId());
    user.getSavedList().add(userSavedHistory);
    userRepository.save(user);
    userSavedHistoryRepository.save(userSavedHistory);
  }
}
