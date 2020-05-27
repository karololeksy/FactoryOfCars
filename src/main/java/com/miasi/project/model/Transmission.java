package com.miasi.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "TRANSMISSIONS")
@Entity
public class Transmission implements InStock {

    @Id
    private int id;

    private String name;

    private boolean automatic;

    private int gears;

    private double price;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean inStock;

}
