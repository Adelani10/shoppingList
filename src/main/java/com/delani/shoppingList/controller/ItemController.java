package com.delani.shoppingList.controller;


import com.delani.shoppingList.model.Item;
import com.delani.shoppingList.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class ItemController {

  private ItemService itemService;

  @GetMapping("/items")
  public ResponseEntity<List<Item>> getallItems(){
      return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
  }
}
