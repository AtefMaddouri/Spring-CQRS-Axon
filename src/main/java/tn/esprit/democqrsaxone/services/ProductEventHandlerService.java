package tn.esprit.democqrsaxone.services;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import tn.esprit.democqrsaxone.entities.Product;
import tn.esprit.democqrsaxone.events.ProductCreatedEvent;
import tn.esprit.democqrsaxone.queries.RetrieveById;
import tn.esprit.democqrsaxone.queries.RetrieveAllProducts;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductEventHandlerService {

    private final IProductService productService;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = Product.builder()
                .name(event.name())
                .quantity(event.quantity())
                .build();
        productService.add(product);
    }

    @QueryHandler
    public List<Product> on(RetrieveAllProducts query) {
        return productService.findAll();
    }

    @QueryHandler
    public Product on(RetrieveById query) {
        return productService.findById(query.productId());
    }
}
