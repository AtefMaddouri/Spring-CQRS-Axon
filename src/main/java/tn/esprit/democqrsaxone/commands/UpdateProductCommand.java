package tn.esprit.democqrsaxone.commands;

public record UpdateProductCommand(long id, String name, int quantity)  {
}
