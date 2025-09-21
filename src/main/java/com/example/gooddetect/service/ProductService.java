package com.example.gooddetect.service;

import com.example.gooddetect.model.Product;
import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
}
