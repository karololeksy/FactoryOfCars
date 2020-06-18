package com.miasi.project.delegates;

import com.miasi.project.module.EmailService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SendOrderMail implements JavaDelegate {

    private final EmailService emailService;
    private final CheckMaterialAvability checkMaterialAvability;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("Wysylam maila z zamowieniem!");
        emailService.sendOrder(checkMaterialAvability.getCarOrder());
    }
}
