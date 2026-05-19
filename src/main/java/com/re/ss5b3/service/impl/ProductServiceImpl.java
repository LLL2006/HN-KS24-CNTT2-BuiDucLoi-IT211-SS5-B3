package com.re.ss5b3.service.impl;


import com.re.ss5b3.model.entity.Product;
import com.re.ss5b3.repository.ProductRepository;
import com.re.ss5b3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tìm thấy sản phẩm có id = " + id));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
