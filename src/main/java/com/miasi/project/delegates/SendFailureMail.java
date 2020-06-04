package com.miasi.project.delegates;

import com.miasi.project.module.EmailService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SendFailureMail implements JavaDelegate {

    private final EmailService emailServicel;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        emailServicel.sendFailure();
    }
}
