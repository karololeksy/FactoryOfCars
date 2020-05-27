package com.miasi.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "TIRES")
@Entity
public class Tires implements InStock {

    @Id
    private int id;

    private String manufacturer;

    private int size;

    private double price;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean inStock;

}
