package com.miasi.project.delegates;

import com.miasi.project.model.CarOrder;
import com.miasi.project.model.DeliveredParts;
import com.miasi.project.module.Warehouse;
import com.miasi.project.module.Wholesale;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PutMaterialWarehouse implements JavaDelegate {

    private CarOrder carOrder;

    private final Wholesale wholesale;
    private final Warehouse warehouse;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        wholesale.orderParts(carOrder);
        DeliveredParts deliveredParts = wholesale.receiveParts();
        warehouse.addEngine(deliveredParts.getEngine());
        warehouse.addTransmission(deliveredParts.getTransmission());
        warehouse.addTires(deliveredParts.getTires());
        warehouse.addPaint(deliveredParts.getPaint());
    }

    public void setCarOrder(CarOrder carOrder) {
        this.carOrder = carOrder;
    }
}
