package com.miu.waa.repository;

import com.miu.waa.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {

    private static List<Product> products = new ArrayList<>();

    public void save(Product product) {
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }

    public Product find(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void deleteById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
                System.out.println("deleted product: " + product);
            }
        }
    }

    public void update(Product product) {
        for (Product product1 : products) {
            if (product1.getId().equals(product.getId())) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                System.out.println("updated product: " + product);
            }
        }
    }
}
