package com.sys.gin.mapper;

import org.springframework.stereotype.Component;

import com.sys.gin.dto.product.ProductDto;
import com.sys.gin.entities.Product;

@Component
public class ProductMapper implements EntityMapper<Product, ProductDto> {

  @Override
  public ProductDto toDTO(Product entity) {
    if (entity == null) {
      return null;
    }

    ProductDto dto = new ProductDto();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setPrice(entity.getPrice());
    dto.setStock(entity.getStock());
    return dto;
  }

  @Override
  public Product toEntity(ProductDto dto) {
    if (dto == null) {
      return null;
    }

    Product product = new Product();
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());
    product.setStock(dto.getStock());
    return product;
  }
}
