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
@CrossOrigin(origins = "http://localhost:3000")
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

  @PutMapping("/add_to_current_list")
  public ResponseEntity<List<Item>> addToCurrentList(@RequestBody Item item) {
      return new ResponseEntity<>(userService.addToCurrentList(item), HttpStatus.OK);
  }

  @PutMapping("/remove_from_current_list/{id}")
  public ResponseEntity<List<Item>> removeFromCurrentList(@PathVariable String id) {
      return new ResponseEntity<>(userService.removeFromCurrentList(id), HttpStatus.OK);
  }

  @PutMapping("/increase_item_quantity/{id}")
  public ResponseEntity<Integer> increaseQty(@PathVariable String id) {
      return new ResponseEntity<>(userService.increaseQty(id), HttpStatus.OK);
  }

  @PutMapping("/decrease_item_quantity/{id}")
  public ResponseEntity<Integer> decreaseQty(@PathVariable String id) {
      return new ResponseEntity<>(userService.decreaseQty(id), HttpStatus.OK);
  }

}
