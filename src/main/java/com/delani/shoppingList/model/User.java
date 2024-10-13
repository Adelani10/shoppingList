package com.delani.shoppingList.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UsersCollection")
public class User {

  @Id
  private String userId;
  private String username;
  private String password;
  private List<Item> wantList;

}
