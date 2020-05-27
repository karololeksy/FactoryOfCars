package com.miasi.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "ENGINES")
@Entity
public class Engine implements InStock {

    @Id
    private int id;

    private String name;

    private int capacity;

    private int power;

    private double price;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean inStock;

}
