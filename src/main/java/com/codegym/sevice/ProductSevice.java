package com.codegym.sevice;

import com.codegym.model.Product;

import java.util.List;

public interface ProductSevice {
    List<Product>fillAll();
    Product findById(int id);
    void save(Product product);
    void  update(int id,Product product);
    void delete(int id);


}
