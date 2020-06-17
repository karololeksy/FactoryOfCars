package com.miasi.project.delegates;

import com.miasi.project.model.CarOrder;
import com.miasi.project.module.Warehouse;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.data.convert.ThreeTenBackPortConverters;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CheckMaterialAvability implements JavaDelegate {

    private final Warehouse warehouse;
    private final PutMaterialWarehouse putMaterialWarehouse;
    private CarOrder carOrder;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        if(isNoInStockAllParts(carOrder)) {
            delegateExecution.setVariable("isPartsPresent", false);
            putMaterialWarehouse.setCarOrder(carOrder);
        } else {
            delegateExecution.setVariable("isPartsPresent", true);
        }
    }

    private boolean isNoInStockAllParts(CarOrder carOrder) {
        return (isNoEngine(carOrder.getEngineId()) || isNoTransmission(carOrder.getTransmissionId())
                || isNoTires(carOrder.getTiresId()) || isNoPaint(carOrder.getPaintId()));
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

    public CarOrder getCarOrder() {
        return carOrder;
    }

    public void setCarOrder(CarOrder carOrder) {
        this.carOrder = carOrder;
    }

}
