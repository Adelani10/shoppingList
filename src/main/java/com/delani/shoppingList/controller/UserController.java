package com.delani.shoppingList.controller;


import com.delani.shoppingList.model.Item;
import com.delani.shoppingList.model.User;
import com.delani.shoppingList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody User user) {
      return new ResponseEntity<>(userService.register(user), HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody User user) {
      return new ResponseEntity<>(userService.verify(user), HttpStatus.OK);
  }

  @GetMapping("/current_user")
  public ResponseEntity<User> getCurrentUser() {
      return new ResponseEntity<>(userService.getCurrentUser(), HttpStatus.OK);
  }

  @PutMapping("/current_list")
  public ResponseEntity<List<Item>> addToCurrentList(@RequestBody Item item) {
      return new ResponseEntity<>(userService.addToCurrentList(item), HttpStatus.OK);
  }

}
