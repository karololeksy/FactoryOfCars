package com.miasi.project.controller;

import com.miasi.project.model.*;
import com.miasi.project.service.ShopService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @PostMapping("/order")
    public ResponseEntity<Object> makeOrder(@RequestBody CarOrder carOrder) {
        shopService.orderCar(carOrder);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/models")
    public ResponseEntity<List<Model>> getModels() {
        return new ResponseEntity<>(shopService.getModels(), HttpStatus.OK);
    }

    @GetMapping("/engines")
    public ResponseEntity<List<Engine>> getEngines() {
        return new ResponseEntity<>(shopService.getEngines(), HttpStatus.OK);
    }

    @GetMapping("/transmissions")
    public ResponseEntity<List<Transmission>> getTransmissions() {
        return new ResponseEntity<>(shopService.getTransmissions(), HttpStatus.OK);
    }

    @GetMapping("/tires")
    public ResponseEntity<List<Tires>> getTires() {
        return new ResponseEntity<>(shopService.getTires(), HttpStatus.OK);
    }

    @GetMapping("/paints")
    public ResponseEntity<List<Paint>> getPaints() {
        return new ResponseEntity<>(shopService.getPaints(), HttpStatus.OK);
    }
}
