package tn.esprit.democqrsaxone.services;

import tn.esprit.democqrsaxone.entities.Product;

import java.util.List;

public interface IProductService {
    Product add(Product product);

    Product findById(long idProduct);

    List<Product> findAll();

    void delete(long idProduct);


}
