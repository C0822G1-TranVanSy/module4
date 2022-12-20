package codegym.service;


import codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();

    void add(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(Product product);

    List<Product> findByName(String name);
}
