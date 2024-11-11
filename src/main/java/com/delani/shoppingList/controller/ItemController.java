package com.delani.shoppingList.controller;


import com.delani.shoppingList.model.Item;
import com.delani.shoppingList.repo.SearchRepository;
import com.delani.shoppingList.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ItemController {

  @Autowired
  private ItemService itemService;

  @Autowired
  private SearchRepository searchRepository;

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
    if (searchRepository.findByKeyword(keyword) != null){
      return new ResponseEntity<>(searchRepository.findByKeyword(keyword), HttpStatus.OK);
    } else {
      throw new RuntimeException("Error finding item with keyword" + " " + keyword);
    }
  }

}
