package com.delani.shoppingList.service;

import com.delani.shoppingList.model.Item;
import com.delani.shoppingList.repo.ItemRepository;

import java.util.List;

public class ItemService {

  private ItemRepository itemRepository;

  public List<Item> getAllItems() {
    return itemRepository.findAll();
  }
}
