package tn.esprit.democqrsaxone.commands;

import lombok.Getter;

//une command est un object ummuable
public record CreateProductCommand(String name, int quantity)  {
}
