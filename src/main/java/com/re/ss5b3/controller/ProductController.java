package com.re.ss5b3.controller;


import com.re.ss5b3.model.entity.Product;
import com.re.ss5b3.model.response.ApiDataResponse;
import com.re.ss5b3.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<?>> getAllProducts() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách thành công",
                productService.getAllProducts(),
                HttpStatus.OK
        ),  HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy thông tin sản phẩm thành công",
                productService.getProductById(id),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<?>> addProduct(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm sản phẩm thành công",
                productService.addProduct(product),
                HttpStatus.CREATED
        ),  HttpStatus.CREATED);
    }
}
