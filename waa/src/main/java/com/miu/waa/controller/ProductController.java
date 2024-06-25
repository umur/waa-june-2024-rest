package com.miu.waa.controller;

import com.miu.waa.entity.Product;
import com.miu.waa.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        productService.update(product);
        return product;
    }

    @DeleteMapping
    public void delete(@RequestBody Product product) {
        productService.delete(product.getId());
    }

    @GetMapping("/filter")
    public List<Product> filterByColor(@RequestParam String color) {
        return null;
    }
}
