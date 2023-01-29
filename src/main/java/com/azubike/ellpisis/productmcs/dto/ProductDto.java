package com.azubike.ellpisis.productmcs.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
public class ProductDto {
  @With private String id;
  @NotBlank(message = "description cannot be blank")
  private String description;
  @NotBlank(message = "price cannot be blank")
  private Double price;
}
