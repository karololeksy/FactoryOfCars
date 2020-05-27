package com.miasi.project.module;

import com.miasi.project.exception.WarehouseProblemException;
import com.miasi.project.model.Engine;
import com.miasi.project.model.Paint;
import com.miasi.project.model.Tires;
import com.miasi.project.model.Transmission;
import com.miasi.project.repository.*;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Warehouse {

    private static final String AVAILABLE_MESSAGE = "Component not available";

    private final EngineRepository engineRepository;
    private final PaintRepository paintRepository;
    private final TiresRepository tiresRepository;
    private final TransmissionRepository transmissionRepository;

    public void addEngine(Engine engine) {
        addComponent(engine, engineRepository);
    }

    public void addTransmission(Transmission transmission) {
        addComponent(transmission, transmissionRepository);
    }

    public void addTires(Tires tires) {
        addComponent(tires, tiresRepository);
    }

    public void addPaint(Paint paint) {
        addComponent(paint, paintRepository);
    }

    private <T> void addComponent(T t, InStockRepository<T> inStockRepository) {
        inStockRepository.save(t);
    }

    public boolean isEngine(int id) {
        return isComponent(id, engineRepository);
    }

    public boolean isTransmission(int id) {
        return isComponent(id, transmissionRepository);
    }

    public boolean isTires(int id) {
        return isComponent(id, tiresRepository);
    }

    public boolean isPaint(int id) {
        return isComponent(id, paintRepository);
    }

    private <T> boolean isComponent(int id, InStockRepository<T> inStockRepository) {
        return inStockRepository.existsByIdAndAndInStockIsTrue(id);
    }

    public Engine getEngine(int id) {
        return getComponent(id, engineRepository);
    }

    public Transmission getTransmission(int id) {
        return getComponent(id, transmissionRepository);
    }

    public Tires getTires(int id) {
        return getComponent(id, tiresRepository);
    }

    public Paint getPaint(int id) {
        return getComponent(id, paintRepository);
    }

    private <T> T getComponent(int id, InStockRepository<T> inStockRepository) {
        return inStockRepository.findByIdAndInStockIsTrue(id)
                .orElseThrow(() -> new WarehouseProblemException(AVAILABLE_MESSAGE));
    }
}
