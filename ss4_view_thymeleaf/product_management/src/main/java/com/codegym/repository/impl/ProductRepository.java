package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {

    private static final List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Nokia1080",1000000,"vip","Nokia"));
        productList.add(new Product(2,"Iphone8",2000000,"vip1","Iphone"));
        productList.add(new Product(3,"SamSung1975",3000000,"vip pro","SamSung"));
        productList.add(new Product(4,"IphoneX",4000000,"vip2","Iphone"));
        productList.add(new Product(5,"IphoneXIII",5000000,"vip3","Iphone"));
    }

    @Override
    public List<Product> selectAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product p: productList
             ) {
            if(id == p.getId()){
                return p;
            }
        }
        return null;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size() ; i++) {
            if(id == productList.get(i).getId()){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(Product product) {
        productList.set(findIndexById(product.getId()),product);
    }

    @Override
    public void delete(int id) {
        productList.remove(findIndexById(id));
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList1 = new ArrayList<>();
        for (Product p: productList) {
            if(p.getName().contains(name)){
                productList1.add(p);
            }
        }
        return productList1;
    }

}
