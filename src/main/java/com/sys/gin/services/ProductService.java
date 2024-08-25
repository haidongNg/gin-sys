package com.sys.gin.services;

import java.util.List;

import com.sys.gin.dto.product.ProductDto;

public interface ProductService {
  ProductDto createProduct(ProductDto product);

  ProductDto getProductById(Long id);

  List<ProductDto> getAllProducts();

  ProductDto updateProduct(Long id, ProductDto product);

  void detelteProduct(Long id);
}
