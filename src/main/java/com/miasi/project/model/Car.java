package com.miasi.project.model;

import lombok.Data;

@Data
public class Car {

    private Model model;
    private Engine engine;
    private Transmission transmission;
    private Tires tires;
    private Paint paint;
    private int price;
    private boolean available;

}
