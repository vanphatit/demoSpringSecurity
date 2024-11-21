package com.phatlee.demospringsecurity.services;

import com.phatlee.demospringsecurity.entities.Product;

import java.util.List;

public interface iProductService {
    List<Product> listAll();

    Product save(Product product);

    Product get(Long id);

    void delete(Long id);
}
