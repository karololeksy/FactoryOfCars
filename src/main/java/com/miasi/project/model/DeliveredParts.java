package com.miasi.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveredParts {

    private Engine engine;
    private Transmission transmission;
    private Tires tires;
    private Paint paint;

}
