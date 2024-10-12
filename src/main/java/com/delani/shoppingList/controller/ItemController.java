package com.delani.shoppingList.controller;


import com.delani.shoppingList.model.Item;
import com.delani.shoppingList.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/items")
  public void addItem(@RequestBody Item item) {
    itemService.addItem(item);
  }

  @GetMapping("/items/{keyword}")
  public ResponseEntity<List<Item>> search (@PathVariable String keyword) {
    if (itemService.search(keyword) != null){
      return new ResponseEntity<>(itemService.search(keyword), HttpStatus.OK);
    } else {
      throw new RuntimeException("Error finding item with keyword" + " " + keyword);
    }
  }
}
