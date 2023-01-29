package com.azubike.ellpisis.productmcs.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
public class Product {
  @Id private String id;
  private String description;
  private Double price;
}
