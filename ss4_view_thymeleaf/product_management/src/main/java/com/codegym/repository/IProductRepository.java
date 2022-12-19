package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectAll();

    void add(Product product);

    Product findById(int id);

    int findIndexById(int id);

    void update(Product product);

    void delete(int id);

    List<Product> findByName(String name);
}
