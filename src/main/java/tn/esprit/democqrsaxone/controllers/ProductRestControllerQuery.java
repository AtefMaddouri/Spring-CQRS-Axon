package tn.esprit.democqrsaxone.controllers;

import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.*;
import tn.esprit.democqrsaxone.entities.Product;
import tn.esprit.democqrsaxone.queries.RetrieveById;
import tn.esprit.democqrsaxone.queries.RetrieveAllProducts;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products/query")
@RequiredArgsConstructor
public class ProductRestControllerQuery {

    private final QueryGateway queryGateway;

    @GetMapping
    public CompletableFuture<List<Product>> retrieveProducts() {
        return queryGateway.query(new RetrieveAllProducts(), ResponseTypes.multipleInstancesOf(Product.class));
    }

    @GetMapping("{productId}")
    public CompletableFuture<Optional<Product>> retrieveById(@PathVariable long productId) {
        return queryGateway.query(new RetrieveById(productId), ResponseTypes.optionalInstanceOf(Product.class));
    }






}
