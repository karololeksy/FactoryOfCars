package com.miasi.project.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "MODELS")
@Entity
public class Model {

    @Id
    private int id;

    private String name;

    private double price;
}
