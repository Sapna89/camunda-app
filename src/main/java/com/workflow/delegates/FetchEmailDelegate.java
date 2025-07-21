package com.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


public class FetchEmailDelegate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("coming from fetch email delegate");
        execution.setVariable("userEmailFromFetchEmailDelegate", "Mimi09@gmail.com");

        System.out.println("accessing the input varible inside BPMN :: " + execution.getVariable("useEmailInput"));

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
