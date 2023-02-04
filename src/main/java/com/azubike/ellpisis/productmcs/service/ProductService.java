package com.azubike.ellpisis.productmcs.service;

import com.azubike.ellpisis.productmcs.dto.ProductDto;
import org.springframework.data.domain.Range;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
  Flux<ProductDto> findAll();

  Mono<ProductDto> findById(String id);

  Mono<ProductDto> save(Mono<ProductDto> productDto);

  Mono<ProductDto> update(Mono<ProductDto>productDto , String id );

  Flux<ProductDto> getProductsByPriceRange(double min , double max);

  Mono<Void> delete(String id);


}
