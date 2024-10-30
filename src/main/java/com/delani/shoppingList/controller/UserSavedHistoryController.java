package com.delani.shoppingList.controller;


import com.delani.shoppingList.model.UserSavedHistory;
import com.delani.shoppingList.service.UserSavedHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UserSavedHistoryController {

  @Autowired
  private UserSavedHistoryService userSavedHistoryService;

  @PostMapping("/user_saved_history")
  public void addToHistory(@RequestBody UserSavedHistory userSavedHistory) {
    userSavedHistoryService.addToHistory(userSavedHistory);

  }
}
