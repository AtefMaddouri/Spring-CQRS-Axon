package tn.esprit.democqrsaxone.controllers;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;
import tn.esprit.democqrsaxone.commands.CreateProductCommand;
import tn.esprit.democqrsaxone.commands.UpdateProductCommand;
import tn.esprit.democqrsaxone.entities.Product;
import tn.esprit.democqrsaxone.services.IProductService;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRestControllerCommand {

    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    private final IProductService productService;

    @GetMapping("readEventStore/{idEvent}")
    public Stream eventStore(@PathVariable String idEvent) {
        return eventStore.readEvents(idEvent).asStream();
    }

    @PostMapping
    public CompletableFuture<Long> add(@RequestBody Product product) {
        return commandGateway.send(new CreateProductCommand(product.getName(), product.getQuantity()));
    }

    @PutMapping
    public CompletableFuture<Long> update(@RequestBody Product product) {
        return commandGateway.send(new UpdateProductCommand(product.getId(), product.getName(), product.getQuantity()));
    }





}
