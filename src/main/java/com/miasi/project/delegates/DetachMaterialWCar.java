package com.miasi.project.delegates;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DetachMaterialWCar implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

    }
}
