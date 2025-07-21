//package com.workflow.delegates;
//
//import org.camunda.bpm.engine.delegate.DelegateExecution;
//import org.camunda.bpm.engine.delegate.JavaDelegate;
//import org.openjdk.nashorn.internal.objects.annotations.Function;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class FetchUserRoleDelegate implements JavaDelegate {
//
//
//    @Override
//    public void execute(DelegateExecution execution) throws Exception {
//        System.out.println("coming from Fetch UserRole Delegate");
//
//        List<Map<String, String>> subjectList = new ArrayList<Map<String, String>>();
//
//        for(Integer i = 1; i < 5 ; i++) {
//            Map<String, String> subject = new HashMap<String, String>();
//            subject.put("id", Integer.toString(i));
//            subjectList.add(subject);
//        }
//
//        execution.setVariable("userRoleDelegate", subjectList);
//
////        System.out.println("coming from Fetch UserRole Delegate :: ENDED");
//
//    }
////    @Override
////    public void execute(DelegateExecution execution) throws Exception {
////        System.out.println("coming from Fetch UserRole Delegate");
////
////        execution.setVariable("userRoleDelegate", "Tech Lead");
////    }
//}
