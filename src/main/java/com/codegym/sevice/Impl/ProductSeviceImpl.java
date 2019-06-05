package com.codegym.sevice.Impl;

import com.codegym.model.Product;
import com.codegym.sevice.ProductSevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSeviceImpl implements ProductSevice {
    private static Map<Integer,Product>product = new HashMap<>();
    static {
        product.put(1,new Product(1,"tivi",20000,20));
        product.put(2,new Product(2,"tu lanh",20000,20));
        product.put(3,new Product(3,"may sinh to",20000,20));
        product.put(4,new Product(4,"bep ga",20000,20));

    }
    @Override
    public List<Product> fillAll() {
        ArrayList<Product> products = new ArrayList<>(product.values());
        return products;
    }

    @Override
    public Product findById(int id) {
        return product.get(id);
    }

    @Override
    public void save( Product product) {
        this.product.put(product.getId(),product);

    }

    @Override
    public void update(int id, Product product) {
        this.product.put(id,product);

    }

    @Override
    public void delete(int id) {
        this.product.remove(id);

    }
}
