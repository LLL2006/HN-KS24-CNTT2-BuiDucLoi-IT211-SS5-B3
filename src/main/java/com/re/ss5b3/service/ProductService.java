package com.re.ss5b3.service;


import com.re.ss5b3.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product addProduct(Product product);
}
