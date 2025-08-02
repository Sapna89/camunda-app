package com.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


public class FetchEmailDelegate implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchEmailDelegate.class);


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Executing FetchEmailDelegate for process instance: {}", execution.getProcessInstanceId());

        execution.setVariable("userEmailFromFetchEmailDelegate", "Mimi09@gmail.com");

        LOGGER.info("Accessing the input variable inside BPMN :: {}", execution.getVariable("useEmailInput"));

        execution.setVariable("userEmailFromFetchEmailDelegate", "Mimi09@gmail.com");

/*
        Output:
        coming from fetch email delegate
        accessing the input varible inside BPMN :: sapna.naveen@gmail.com
        userEmailFromFetchEmailDelegate :: Mimi09@gmail.com

        the output above proves that the code of execution first executes the input parameter and then the output parameter
 */
    }
}
