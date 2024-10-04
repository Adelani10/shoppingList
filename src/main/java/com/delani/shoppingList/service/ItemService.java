package com.delani.shoppingList.service;

import com.delani.shoppingList.model.Item;
import com.delani.shoppingList.repo.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemService {

  private ItemRepository itemRepository;

  public List<Item> getAllItems() {
    return itemRepository.findAll();
  }
}
