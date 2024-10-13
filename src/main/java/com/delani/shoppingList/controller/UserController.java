package com.delani.shoppingList.controller;


import com.delani.shoppingList.model.User;
import com.delani.shoppingList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody User user) {
    try {
      return new ResponseEntity<>(userService.register(user), HttpStatus.OK);
    } catch (RuntimeException ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody User user) {
    try {
      return new ResponseEntity<>(userService.verify(user), HttpStatus.OK);
    } catch (RuntimeException ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
  }

  @GetMapping("/current_user")
  public ResponseEntity<User> getCurrentUser() {
    if (userService.getCurrentUser() != null) {
      return new ResponseEntity<>(userService.getCurrentUser(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(userService.getCurrentUser(), HttpStatus.BAD_REQUEST);
    }
  }

}
