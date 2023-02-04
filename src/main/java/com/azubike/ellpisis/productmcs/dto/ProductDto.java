package com.azubike.ellpisis.productmcs.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDto {
  @With private String id;

  @NotBlank(message = "description cannot be blank")
  private String description;

  @NotNull(message = "price cannot be null")
  private Double price;
}
