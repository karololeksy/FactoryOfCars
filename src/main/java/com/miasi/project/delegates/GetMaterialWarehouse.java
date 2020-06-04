package com.miasi.project.delegates;

import com.miasi.project.model.CarOrder;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Random;

@RequiredArgsConstructor
@Component
public class GetMaterialWarehouse implements JavaDelegate {

    private CarOrder carOrder;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Random random = new Random(System.currentTimeMillis());
        if(random.nextInt(10) < 10) {
            throw new BpmnError("100", "Lift problem");
        }

    }

    public void setCarOrder(CarOrder carOrder) {
        this.carOrder = carOrder;
    }
}
