package com.miasi.project.delegates;

import com.miasi.project.service.Database;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PutMaterialCar implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("Umieszczam czesci w samochodzi!");
        if(Database.mount) {
            delegateExecution.setVariable("isPartsCorrect", true);
        } else {
            delegateExecution.setVariable("isPartsCorrect", false);
            Database.mount = true;
        }
    }
}
