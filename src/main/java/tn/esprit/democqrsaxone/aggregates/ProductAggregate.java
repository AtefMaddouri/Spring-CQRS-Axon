package tn.esprit.democqrsaxone.aggregates;

import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;
import tn.esprit.democqrsaxone.commands.CreateProductCommand;
import tn.esprit.democqrsaxone.commands.UpdateProductCommand;
import tn.esprit.democqrsaxone.events.ProductCreatedEvent;
import tn.esprit.democqrsaxone.events.ProductUpdatedEvent;

@Aggregate
@NoArgsConstructor //required by axone
public class ProductAggregate {

    @AggregateIdentifier
    private long id;
    private String name;
    private int quantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand command){
        Assert.isTrue(command.quantity()>0,"Product qte must be greater than 0");

        AggregateLifecycle.apply(new ProductCreatedEvent(command.name(), command.quantity()));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event){
        this.name=event.name();
        this.quantity=event.quantity();
    }

    @CommandHandler
    public ProductAggregate(UpdateProductCommand command){
        Assert.isTrue(command.quantity()>0,"Product qte must be greater than 0");

        AggregateLifecycle.apply(new ProductUpdatedEvent(command.id(),command.name(), command.quantity()));
    }

    @EventSourcingHandler
    public void on(ProductUpdatedEvent event){
        this.id=event.id();
        this.name=event.name();
        this.quantity=event.quantity();
    }
}
