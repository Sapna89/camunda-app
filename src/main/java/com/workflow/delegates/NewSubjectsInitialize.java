package com.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NewSubjectsInitialize implements JavaDelegate{
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<Map<String, String>> subjectList = new ArrayList<Map<String, String>>();

        for(Integer i = 1; i < 5 ; i++) {
            Map<String, String> subject = new HashMap<String, String>();
            subject.put("id", Integer.toString(i));
            subjectList.add(subject);
        }
        execution.setVariable("subjectList", subjectList);
    }
}
