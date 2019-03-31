package com.example.SpringDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="person")

public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private final UUID id;

    private final String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }







}
