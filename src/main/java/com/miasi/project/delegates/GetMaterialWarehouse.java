package com.miasi.project.delegates;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class GetMaterialWarehouse implements JavaDelegate {

    private boolean error = true;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("Pobieram czesci z magazynu!");
        if(error) {
            error = false;
            throw new BpmnError("100", "Lift problem");
        }
    }
}
