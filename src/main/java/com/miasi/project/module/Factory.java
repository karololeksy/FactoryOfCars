package com.miasi.project.module;

import com.miasi.project.model.CarOrder;
import com.miasi.project.model.DeliveredParts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Factory {

    private final Warehouse warehouse;
    private Wholesale wholesale;

    public void makeCar(CarOrder carOrder) {
        deliverParts(carOrder);
    }

    private void deliverParts(CarOrder carOrder) {
        if (isNoInStockAllParts(carOrder)) {
            makeOrder(carOrder);
            DeliveredParts deliveredParts = receiveParts();
            addToWarehouse(deliveredParts);
        }
    }

    private boolean isNoInStockAllParts(CarOrder carOrder) {
        return (isNoEngine(carOrder.getEngineId()) || isNoTransmission(carOrder.getTransmissionId())
                || isNoTires(carOrder.getTiresId()) || isNoPaint(carOrder.getPaintId()));
    }

    private void makeOrder(CarOrder carOrder) {
        wholesale.orderParts(carOrder);
    }

    private DeliveredParts receiveParts() {
        return wholesale.receiveParts();
    }

    private void addToWarehouse(DeliveredParts deliveredParts) {
        warehouse.addEngine(deliveredParts.getEngine());
        warehouse.addTransmission(deliveredParts.getTransmission());
        warehouse.addTires(deliveredParts.getTires());
        warehouse.addPaint(deliveredParts.getPaint());
    }

    private boolean isNoEngine(int id) {
        return !warehouse.isEngine(id);
    }

    private boolean isNoTransmission(int id) {
        return !warehouse.isTransmission(id);
    }

    private boolean isNoTires(int id) {
        return !warehouse.isTires(id);
    }

    private boolean isNoPaint(int id) {
        return !warehouse.isPaint(id);
    }

    @Autowired(required = false)
    public void setWholesale(Wholesale wholesale) {
        this.wholesale = wholesale;
    }
}
