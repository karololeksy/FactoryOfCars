package com.miasi.project.service;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.EventSubscription;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CamundaService {


    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private ProcessInstance processInstance;
    private EventSubscription subscription;

    public void start() {
        processInstance = runtimeService.startProcessInstanceByKey("carfactory-process");
        subscription = runtimeService.createEventSubscriptionQuery()
                .processInstanceId(processInstance.getId()).eventType("message").singleResult();
    }

    public void receive() {
        runtimeService.messageEventReceived(subscription.getEventName(), subscription.getExecutionId());
    }
}
