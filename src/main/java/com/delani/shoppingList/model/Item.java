package com.delani.shoppingList.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ItemsCollection")
public class Item {

  @Id
  private String id;
  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return Objects.equals(id, item.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  private String image;
  private String category;
  private String note;
  private int quantity;
  private String creatorId;


}
