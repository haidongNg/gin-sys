package com.sys.gin.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sys.gin.dto.product.ProductDto;
import com.sys.gin.services.ProductService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("")
  public ResponseEntity<List<ProductDto>> getAllProducts() {
    List<ProductDto> result = productService.getAllProducts();
    return ResponseEntity.ok(result);
  }

  @PostMapping("")
  public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto) {
    ProductDto result = productService.createProduct(dto);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
    ProductDto result = productService.getProductById(id);
    return ResponseEntity.ok(result);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductDto> updateProduct(
      @PathVariable Long id, @RequestBody ProductDto dto) {
    ProductDto result = productService.updateProduct(id, dto);
    return ResponseEntity.ok(result);
  }
}
