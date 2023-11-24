package tn.esprit.democqrsaxone.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder
//@FieldDefaults(level = AccessLevel.NONE)
public class Product implements Serializable {

    @Id @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    int quantity;
}
