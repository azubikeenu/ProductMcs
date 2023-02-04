package com.azubike.ellpisis.productmcs.utils;

import com.azubike.ellpisis.productmcs.dto.ProductDto;
import com.azubike.ellpisis.productmcs.entity.Product;
import org.springframework.beans.BeanUtils;

public class ProductMapper {
  public static ProductDto productToDto(Product product) {
    ProductDto productDto = new ProductDto();
    BeanUtils.copyProperties(product, productDto);
    return productDto;
  }

  public static Product dtoToProduct(ProductDto productDto) {
    Product product = new Product();
    BeanUtils.copyProperties(productDto, product);
    return product;
  }
}
