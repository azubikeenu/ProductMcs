package com.azubike.ellpisis.productmcs.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@Builder
@NoArgsConstructor
public class ProductDto {
  @With private String id;
  private String description;
  private Double price;
}
