package tn.esprit.democqrsaxone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.democqrsaxone.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}