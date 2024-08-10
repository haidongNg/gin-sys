package com.sys.gin.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sys.gin.dto.product.ProductDto;
import com.sys.gin.services.ProductService;

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

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {

	  ProductDto result = productService.getProductById(id);
    return ResponseEntity.ok(result);
  }
}
