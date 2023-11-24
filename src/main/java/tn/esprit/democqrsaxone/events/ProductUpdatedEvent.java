package tn.esprit.democqrsaxone.events;

public record ProductUpdatedEvent(long id,String name, int quantity) {}
