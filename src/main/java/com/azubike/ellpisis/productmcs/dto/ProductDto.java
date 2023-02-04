package com.azubike.ellpisis.productmcs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.With;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ProductDto {
  @With private String id;

  @NotBlank(message = "description cannot be blank")
  private String description;

  @NotNull(message = "price cannot be null")
  private Double price;

  public ProductDto() {}

  public ProductDto(String description,Double price) {
    this.description = description;
    this.price = price;
  }
}
