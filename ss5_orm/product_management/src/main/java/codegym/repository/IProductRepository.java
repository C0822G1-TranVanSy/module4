package codegym.repository;


import codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectAll();

    void add(Product product);

    Product findById(int id);

    void update(Product product);

    void delete(Product product);

    List<Product> findByName(String name);
}
