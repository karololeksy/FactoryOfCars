package com.miasi.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PAINTS")
public class Paint implements InStock {

    @Id
    private int id;

    private String color;

    private double price;

    private boolean inStock;

}
