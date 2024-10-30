package com.delani.shoppingList.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UsersHistoryCollection")
public class UserSavedHistory {
  @Id
  private String id;
  private String title;
  private List<Item> items;
  private boolean completed;
  private LocalDate localDate;
  private String userId;
}