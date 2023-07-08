package me.dio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

@Entity(name = "HEROES")
@Data
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int xp;
    /*
     * The version field is marked with the @Version annotation. This means JPA will
     * automatically take care of versioning for the Hero entity, which helps
     * prevent concurrent modification conflicts.
     */
    @Version
    private int version;

}
