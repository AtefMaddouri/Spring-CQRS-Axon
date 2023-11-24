package tn.esprit.democqrsaxone.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.democqrsaxone.entities.Product;
import tn.esprit.democqrsaxone.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IProductServiceImp implements IProductService{
    private final ProductRepository productRepository;

    @Override
    public Product add(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Product findById(long idProduct) {
        return productRepository.findById(idProduct).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(long idProduct) {
        productRepository.deleteById(idProduct);
    }



}
