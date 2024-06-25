package com.miu.waa.service;

import com.miu.waa.entity.Product;
import com.miu.waa.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public void save(Product product) {
        if (product.getPrice() < 0) {
            throw new RuntimeException("Price can't be less than 0");
        }
        productRepo.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.find(id);
    }

    @Override
    public void update(Product product) {
        productRepo.update(product);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }
}
