package com.azubike.ellpisis.productmcs.service;

import com.azubike.ellpisis.productmcs.dto.ProductDto;
import com.azubike.ellpisis.productmcs.repository.ProductRepository;
import com.azubike.ellpisis.productmcs.utils.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository repository;

  @Override
  public Flux<ProductDto> findAll() {
    return repository.findAll().map(ProductMapper::productToDto);
  }

  @Override
  public Mono<ProductDto> findById(String id) {
    return repository
        .findById(id)
        .map(ProductMapper::productToDto)
        .switchIfEmpty(monoResponseStatusNotFoundException(id));
  }

  @Override
  public Mono<ProductDto> save(Mono<ProductDto> productDto) {
    return productDto
        .map(ProductMapper::DtoToProduct)
        .flatMap(repository::save)
        .map(ProductMapper::productToDto);
  }

  @Override
  public Mono<ProductDto> update(Mono<ProductDto> productDto, String id) {
    return repository
        .findById(id)
        .flatMap(p -> productDto.map(ProductMapper::DtoToProduct))
        .flatMap(repository::save)
        .map(ProductMapper::productToDto);
  }

  @Override
  public Mono<Void> delete(String id) {
    return findById(id).map(ProductMapper::DtoToProduct).flatMap(repository::delete);
  }

  private <T> Mono<T> monoResponseStatusNotFoundException(String id) {
    return Mono.error(
        new ResponseStatusException(
            HttpStatus.NOT_FOUND, "product  with given id : " + id + " Not found"));
  }
}
