package com.miasi.project.module;

import com.miasi.project.exception.WarehouseProblemException;
import com.miasi.project.model.*;
import com.miasi.project.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Wholesale {

    private static final String AVAILABLE_MESSAGE = "Unknown component";

    private final EngineRepository engineRepository;
    private final PaintRepository paintRepository;
    private final TiresRepository tiresRepository;
    private final TransmissionRepository transmissionRepository;

    private DeliveredParts deliveredParts;

    public void orderParts(CarOrder carOrder) {
        Engine engine = orderComponent(carOrder.getEngineId(), engineRepository);
        Transmission transmission = orderComponent(carOrder.getTransmissionId(), transmissionRepository);
        Tires tires = orderComponent(carOrder.getTiresId(), tiresRepository);
        Paint paint = orderComponent(carOrder.getPaintId(), paintRepository);
        deliveredParts = new DeliveredParts(engine, transmission, tires, paint);
    }

    public DeliveredParts receiveParts() {
        return deliveredParts;
    }

    private <T extends InStock> T orderComponent(int id, InStockRepository<T> inStockRepository) {
        T t = inStockRepository.findById(id)
                .orElseThrow(() -> new WarehouseProblemException(AVAILABLE_MESSAGE));
        inStockRepository.flush();
        t.setInStock(true);
        return t;
    }
}
