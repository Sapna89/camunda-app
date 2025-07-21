package com.workflow.controllers;

import com.workflow.delegates.FetchEmailDelegate;
import jakarta.annotation.Resource;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Expression;

/*
    types of Script tasks:
    ---------------------
    1. InlineScript: we write the task instide the task itself.
    2. External Resource: Script in written somewhere else and that file name is called inside of the bpmn.


    Service Task: It invokes or executes the business logic defined outside the BPMN.
    ------------
     4 implementations of service tasks:
        1. Java class
        2. Delegate Expression
        3. Expression
        4. REST
*/

@RestController
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "Sapna dont giveup";
    }

    @RequestMapping(value = "/execute/{processKey}", method = RequestMethod.GET)
    public String execute(@PathVariable("processKey") String processKey) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine(); // to get the process engine
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey(processKey);

        String item = "Computer";
        instance.setVariable("bpmnItem", item);
        instance.businessKey("execute-endpoint");
        instance.executeWithVariablesInReturn();

        return "Sapna BPMN is in action!!! :: " + processKey;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String tasks() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine(); // to get the proces engine
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("task_process101");
        instance.executeWithVariablesInReturn();

        return "Task BPMN is in action!!!";
    }




}
