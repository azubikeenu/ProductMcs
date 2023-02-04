package com.azubike.ellpisis.productmcs.bootstrap;

import com.azubike.ellpisis.productmcs.dto.ProductDto;
import com.azubike.ellpisis.productmcs.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
  private final ProductService productService;

  @Override
  public void run(String... args) throws Exception {
    ProductDto productOne = new ProductDto("Samsung Galaxy", 100.0);
    ProductDto productTwo = new ProductDto("Xonami Camera", 190.0);
    ProductDto productThree = new ProductDto("Iphone X", 175.0);
    ProductDto productFour = new ProductDto("Techno Y2", 300.0);

    Flux.just(productOne, productTwo, productThree, productFour)
        .flatMap(productDto -> productService.save(Mono.just(productDto)))
        .subscribe(System.out::println);
  }
}
