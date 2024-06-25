package com.miu.waa.service.product;

import com.miu.waa.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    List<Product> findAll();

    Product findById(Long id);

    void update(Product product);
    void delete(Long id);
}
