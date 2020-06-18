package com.miasi.project.model;

import lombok.Data;

@Data
public class CarOrder {

    private int modelId;
    private int engineId;
    private int transmissionId;
    private int tiresId;
    private int paintId;
    private String email;
    private boolean mountParts;
}
