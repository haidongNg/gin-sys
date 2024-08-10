package com.sys.gin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sys.gin.dto.product.ProductDto;
import com.sys.gin.entities.Product;
import com.sys.gin.exceptions.NotFoundException;
import com.sys.gin.mapper.ProductMapper;
import com.sys.gin.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository productRepository;

  @Autowired private ProductMapper productMapper;

  @Override
  public ProductDto createProduct(ProductDto dto) {
    Product product = productMapper.toEntity(dto);
    Product saveProduct = productRepository.save(product);
    return productMapper.toDTO(saveProduct);
  }

  @Override
  public ProductDto getProductById(Long id) {
    Product result =
        productRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
    return productMapper.toDTO(result);
  }

  @Override
  public List<ProductDto> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return productMapper.toDTOList(products);
  }

  @Override
  public ProductDto updateProduct(ProductDto dto) {
    Product product =
        productRepository
            .findById(dto.getId())
            .orElseThrow(() -> new NotFoundException("Product not found with id: " + dto.getId()));
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());
    product.setStock(dto.getStock());
    Product saveProduct = productRepository.save(product);
    return productMapper.toDTO(saveProduct);
  }

  @Override
  public void detelteProduct(Long id) {
    Product product =
        productRepository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));

    productRepository.deleteById(product.getId());
  }
}
