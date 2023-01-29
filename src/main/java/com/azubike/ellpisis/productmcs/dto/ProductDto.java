package com.azubike.ellpisis.productmcs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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

  @Builder
  public ProductDto() {}
}
