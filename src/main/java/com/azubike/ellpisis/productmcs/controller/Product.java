package com.azubike.ellpisis.productmcs.controller;

import com.azubike.ellpisis.productmcs.dto.ProductDto;
import com.azubike.ellpisis.productmcs.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class Product {
  private final ProductService productService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Flux<ProductDto> findAllProducts() {
    return productService.findAll();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ProductDto> findById(@PathVariable String id) {
    return productService.findById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ProductDto> createProduct(@Valid @RequestBody Mono<ProductDto> productDtoMono) {
    return productService.save(productDtoMono);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(
      value = "{id}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ProductDto> updateProduct(
      @RequestBody Mono<ProductDto> productDtoMono, @PathVariable String id) {
    return productService.update(productDtoMono.map(productDto -> productDto.withId(id)));
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("{id}")
  public Mono<Void> deleteProduct(@PathVariable String id) {
    return productService.delete(id);
  }
}
